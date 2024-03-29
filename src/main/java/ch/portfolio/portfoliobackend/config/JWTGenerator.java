package ch.portfolio.portfoliobackend.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

import static ch.portfolio.portfoliobackend.config.SecurityConstants.*;


@Component
public class JWTGenerator {

//    @Value("${jwt.secret}")
//    private String secret;
//
//    public String generateToken(Authentication authentication){
//
//        String username = authentication.getName();
//        Date current = new Date();
//        Date expiry = new Date(current.getTime() + JWT_EXPIRATION);
//
//        String token = Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(current)
//                .setExpiration(expiry)
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//
//        return token;
//    }
//
//    public String getUsernameFromJWT(String token) {
//
//        Claims claims = Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(token)
//                .getBody();
//
//        return claims.getSubject();
//    }
//
//    public boolean validateToken(String token) {
//            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
//            return true;
//    }
}
