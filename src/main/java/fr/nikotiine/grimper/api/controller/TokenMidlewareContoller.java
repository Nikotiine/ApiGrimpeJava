package fr.nikotiine.grimper.api.controller;

import fr.nikotiine.grimper.api.dal.token.TokenGenerator;

public class TokenMidlewareContoller {
    TokenGenerator jjwt = new TokenGenerator();
    public boolean verifyToken(String token , int idUser){
      return  jjwt.validateToken(token , idUser);
    }
}
