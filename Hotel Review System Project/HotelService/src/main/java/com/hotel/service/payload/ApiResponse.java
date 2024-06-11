package com.hotel.service.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;


@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatusCode httpStatusCode;

}
