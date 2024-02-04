package com.app.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponseStudent {
	
	private  String message;
	private LocalDateTime time;
	
	public ApiResponseStudent(String message) {
		this.message = message;
	}

}
