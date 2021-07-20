package ru.absens.spring.security.jwt.payload.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MessageResponse {
	private String message;

	public MessageResponse(String message) {
	    this.message = message;
	}
}
