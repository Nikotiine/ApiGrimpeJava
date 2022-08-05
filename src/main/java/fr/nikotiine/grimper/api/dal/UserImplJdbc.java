package fr.nikotiine.grimper.api.dal;

import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.Token;
import fr.nikotiine.grimper.api.bo.User;
import fr.nikotiine.grimper.api.dal.token.TokenGenerator;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserImplJdbc implements DAO<User>,LoginDao {
    private final String FIND_ALL_USER="SELECT * FROM USERS";
    private final String FIND_NICK_NAME="SELECT COUNT(*) as total FROM USERS WHERE nick_name=?";
    private final String FIND_EMAIL="SELECT COUNT(*) as total FROM USERS WHERE email=?";
    private final String FIND_PASSWORD="SELECT password FROM USERS WHERE nick_name=?";
    private final String CREATE_USER="INSERT INTO USERS (nick_name, last_name, first_name, email, password, age, sex) VALUES (?,?,?,?,?,?,?)";

    @Override
    public void findOrCreate(User user) throws ApiException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean findNickName = findInDb(this.FIND_NICK_NAME,user.getNickName());
        boolean findEmail = findInDb(this.FIND_EMAIL, user.getEmail());
        if(findNickName ){
            throw new ApiException(CodeErrorDal.PSEUDO_EXISTANT);
        }
        if(findEmail){
            throw new ApiException(CodeErrorDal.EMAIL_EXISTANT);
        }
        try(Connection cnx = ConnectionProvider.getConnection()) {
            ps = cnx.prepareStatement(this.CREATE_USER,PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,user.getNickName());
            ps.setString(2,user.getLastName());
            ps.setString(3,user.getFirstName());
            ps.setString(4,user.getEmail());
            String hashPassword = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());
            ps.setString(5,hashPassword);
            ps.setInt(6,user.getAge());
            ps.setNString(7,String.valueOf(user.getSex()));
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            while (rs.next()){
                user.setIdUser(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public List<User> findAll() {
        List<User> allUsers = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try(Connection cnx = ConnectionProvider.getConnection()) {
            ps = cnx.prepareStatement(this.FIND_ALL_USER);
            rs = ps.executeQuery();
            while (rs.next()){
                int idUser = rs.getInt("id_user");
                String nickName = rs.getString("nick_name");
                String lastName = rs.getString("last_name");
                String firstName = rs.getString("first_name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                int age = rs.getInt("age");
                char sex = rs.getString("sex").charAt(0);
                boolean admin = rs.getBoolean("admin");
                User user = new User(idUser,nickName,lastName,firstName,email,password,age,sex,admin);
                allUsers.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allUsers;
    }

    @Override
    public void update(User object) {

    }

    private boolean findInDb(String findSqlQuery, String lookupString)  {
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean isFind = false;
        try(Connection cnx = ConnectionProvider.getConnection()){
            ps = cnx.prepareStatement(findSqlQuery);
            ps.setString(1,lookupString);
            rs = ps.executeQuery();
            while (rs.next()){
                if(rs.getInt("total")>0){
                    isFind = true;
                }
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isFind;
    }

    @Override
    public Token login(User user) throws ApiException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        TokenGenerator jjwt = new TokenGenerator();
        boolean nickNameIsValid = findInDb(this.FIND_NICK_NAME, user.getNickName());
        if(!nickNameIsValid){
            throw new ApiException(CodeErrorDal.NICK_NAME_INVALIDE);
        }
        try(Connection cnx = ConnectionProvider.getConnection()) {
            ps = cnx.prepareStatement(this.FIND_PASSWORD);
            ps.setString(1, user.getNickName());
            rs = ps.executeQuery();
            if (rs.next()){
                String hashPassword = rs.getString("password");
                if(!BCrypt.checkpw(user.getPassword(),hashPassword)){
                    throw new ApiException(CodeErrorDal.PASSWORD_INVALIDE);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       String generateToken =  jjwt.generator(user.getNickName());
        return new Token(generateToken);

    }
}
