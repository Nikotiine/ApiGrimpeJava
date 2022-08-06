package fr.nikotiine.grimper.api.dal.token;

import fr.nikotiine.grimper.api.bo.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;


import java.security.Key;

public class TokenGenerator {
  private static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
  //User user = new User(1,"toto","tata","titi","tutu","ert",12,'C',false);

   public String generator(String userNickName,int idUser){
      return Jwts.builder().setHeaderParam("id",idUser).setSubject(userNickName).signWith(KEY).compact();
    }

    public boolean validateToken(String acces_token){

       try {
         Jws<Claims> validateToken = Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(acces_token);
         String userNickName=  validateToken.getBody().getSubject();
         int idUser = (int) validateToken.getHeader().get("id");

       } catch (JwtException e) {
           return false;
       }
       return true;
    }
}
