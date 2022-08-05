package fr.nikotiine.grimper.api.dal.token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;

public class TokenGenerator {
  private final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

   public String generator(String userNickName){
      return Jwts.builder().setSubject(userNickName).signWith(KEY).compact();
    }
}
