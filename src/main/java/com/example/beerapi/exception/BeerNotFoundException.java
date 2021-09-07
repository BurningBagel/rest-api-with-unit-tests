package com.example.beerapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BeerNotFoundException extends Exception{
    public BeerNotFoundException(String name){
        super(String.format("Beer with name %s not found in system!",name));
    }
    public BeerNotFoundException(Long id){
        super(String.format("Beer with id %s not found in system!",id));
    }
}
