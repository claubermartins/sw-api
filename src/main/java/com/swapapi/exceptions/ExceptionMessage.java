package com.swapapi.exceptions;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
public class ExceptionMessage {
	private String message;
	private HttpStatus statusCode;
	private List<String> errors;

}
