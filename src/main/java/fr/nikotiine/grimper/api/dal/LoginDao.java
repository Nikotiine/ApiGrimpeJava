package fr.nikotiine.grimper.api.dal;

import fr.nikotiine.grimper.api.ApiException;
import fr.nikotiine.grimper.api.bo.Token;
import fr.nikotiine.grimper.api.bo.User;
import fr.nikotiine.grimper.api.bo.UserPassword;

public interface LoginDao {
    Token login(User user) throws ApiException;
    int changePassword(UserPassword passwords , int idUser) throws ApiException;
}
