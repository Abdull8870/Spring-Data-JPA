package com.SpringDataJPA.DataJPA.controllers.global;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ErrorResponse {

    private LocalDateTime timeStamp;
    private List<String> messages;


    public ErrorResponse(List<String> msg){
        this.messages=msg;
        this.timeStamp=LocalDateTime.now();
    }

}
