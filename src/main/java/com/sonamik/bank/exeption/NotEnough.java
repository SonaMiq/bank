package com.sonamik.bank.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class NotEnough extends RuntimeException{
   private final String message;
   public NotEnough(String message){
       this.message=message;
   }

    @Override
    public String getMessage() {
        return message;
    }
}
