package com.production.prod_ready_features.advices;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ApiResponse<T>{
    // @JsonFormat(pattern = "hh:mm:ss dd-MM-yyy")
    private LocalDateTime timestamp;
    private T data;
    private ApiError error;

    public ApiResponse(){
        this.timestamp=LocalDateTime.now();
    }
    public ApiResponse(T data){
        this();
        this.data=data;
    }
    public ApiResponse(ApiError error){
        this();
        this.error=error;
    }
}
