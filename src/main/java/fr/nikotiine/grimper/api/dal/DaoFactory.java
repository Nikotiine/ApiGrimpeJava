package fr.nikotiine.grimper.api.dal;

import fr.nikotiine.grimper.api.bo.User;
import fr.nikotiine.grimper.api.dal.details.*;

public class DaoFactory {
    public static DAO<User> DaoUser(){return new UserImplJdbc();}
    public static LoginDao loginDao(){return new UserImplJdbc();}

    public static DetailDao approchTypeDao(){return new ApprochTypeImplJdbc();}
    public static DetailDao directionDao(){return new DirectionImplJdbc();}

    public static DetailDao equipmentDao(){return new EquipmentImplJdbc();}
    public static DetailDao levelDao(){return new LevelImplJdbc();}
    public static DetailDao rockTypeDao(){return new RockTypeImplJdbc();
    }
    public static DetailDao routProfilDao(){return new RoutProfilImplJdbc();}
    public static DetailDao equipmentQualityDao(){return new EquimentQualityImplJdbc();}
    public static DetailDao averageRoutNumberDao(){return new AverageRoutNumberImplJdbc();}
}
