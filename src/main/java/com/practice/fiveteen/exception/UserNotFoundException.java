package com.practice.fiveteen.exception;

public class UserNotFoundException extends ResourceNotFoundException{

    public UserNotFoundException() {
        super("Usuario no encontrado.");
    }
}
