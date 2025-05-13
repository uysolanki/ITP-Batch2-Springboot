package com.itp.alibaba.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidError {
	private String message;
    private String field;
    private Object rejectedValue;
}
