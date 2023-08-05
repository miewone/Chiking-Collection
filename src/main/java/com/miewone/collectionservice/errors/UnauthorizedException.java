package com.miewone.collectionservice.errors;

/**
 * Created by wgPark on 2023-08-05.
 */
public class UnauthorizedException extends RuntimeException{

    public UnauthorizedException(String message){
        super(message);
    }

    public UnauthorizedException(String message, Throwable cause){
        super(message, cause);
    }
}
