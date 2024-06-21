package com.SpringDataJPA.DataJPA.controllers.global;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {

    private LocalDateTime timeStamp;
    private String message;

    public ErrorResponse(String msg){
        this.message=msg;
        this.timeStamp=LocalDateTime.now();
    }

}
