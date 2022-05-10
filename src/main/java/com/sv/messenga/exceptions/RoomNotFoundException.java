package com.sv.messenga.exceptions;

public class RoomNotFoundException extends RuntimeException{

    private String message;

    public RoomNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public RoomNotFoundException() {

    }

}
