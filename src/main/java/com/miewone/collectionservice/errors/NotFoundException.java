package com.miewone.collectionservice.errors;

/**
 * Created by wgPark on 2023-08-05.
 */
public class NotFoundException extends RuntimeException{
        public NotFoundException(String message){
            super(message);
        }

        public NotFoundException(String message, Throwable cause){
            super(message, cause);
        }
}
