package ch.portfolio.portfoliobackend.dto;

public class AuthResponseDto {
    private String accessToken;
    private String tokenType = "Bearer ";



    public AuthResponseDto(String token) {
        this.accessToken = token;
    }

    public String getToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setToken(String token) {
        this.accessToken = token;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

}
