package com.sv.messenga.exceptions;

public class UserAddedToRoomException extends RuntimeException{

    private String message;

    public UserAddedToRoomException(String message) {
        super(message);
        this.message = message;
    }

    public UserAddedToRoomException() {

    }

}
