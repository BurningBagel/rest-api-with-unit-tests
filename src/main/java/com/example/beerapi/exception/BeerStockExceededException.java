package com.example.beerapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BeerStockExceededException extends Exception {

    public BeerStockExceededException(Long id, int toIncrement){
        super(String.format("Exceeded max capacity of Beer ID %s when trying to increment by %s",id,toIncrement));
    }
}
