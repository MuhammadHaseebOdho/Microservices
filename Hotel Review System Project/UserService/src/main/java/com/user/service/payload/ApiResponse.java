package com.user.service.payload;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatusCode;

@Data
@Builder
public class ApiResponse {
    private String message;
    private HttpStatusCode httpStatusCode ;
    private boolean success;
}
