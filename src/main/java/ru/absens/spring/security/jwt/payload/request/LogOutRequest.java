package ru.absens.spring.security.jwt.payload.request;

import lombok.Data;

@Data
public class LogOutRequest {
  private Long userId;
}
