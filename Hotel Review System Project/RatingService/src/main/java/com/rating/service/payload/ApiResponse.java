package com.rating.service.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatusCode httpStatusCode;

}
