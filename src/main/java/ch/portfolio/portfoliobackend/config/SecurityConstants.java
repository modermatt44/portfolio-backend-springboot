package ch.portfolio.portfoliobackend.config;

import org.springframework.beans.factory.annotation.Value;

public class SecurityConstants {
    public static final long JWT_EXPIRATION = 70000;

    @Value("${jwt.secret}")
    public static final String JWT_SECRET = null;
}
