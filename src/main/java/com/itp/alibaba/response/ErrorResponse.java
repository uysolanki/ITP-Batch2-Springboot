package com.itp.alibaba.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	private String error;
    private String message;
    private LocalDateTime timestamp;
    private int status;
}
