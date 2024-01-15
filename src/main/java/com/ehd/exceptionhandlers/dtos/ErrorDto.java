package com.ehd.exceptionhandlers.dtos;


import lombok.*;
import org.springframework.http.HttpStatus;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ErrorDto {
    private String status;
    private String ErrorMessage;
    private HttpStatus statusCode;
}
