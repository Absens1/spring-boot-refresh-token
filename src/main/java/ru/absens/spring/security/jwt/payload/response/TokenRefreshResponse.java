package ru.absens.spring.security.jwt.payload.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TokenRefreshResponse {
  private String accessToken;
  private String refreshToken;
  private String tokenType = "Bearer";

  public TokenRefreshResponse(String accessToken, String refreshToken) {
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
  }
}
