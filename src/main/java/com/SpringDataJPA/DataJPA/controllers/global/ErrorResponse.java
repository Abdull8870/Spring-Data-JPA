package com.SpringDataJPA.DataJPA.controllers.global;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ErrorResponse {

    private LocalDateTime timeStamp;
    private String message;
    private List<String> messages;

    public ErrorResponse(String msg){
        this.message=msg;
        this.timeStamp=LocalDateTime.now();
    }

    public ErrorResponse(List<String> msg){
        this.messages=msg;
        this.timeStamp=LocalDateTime.now();
    }

}
