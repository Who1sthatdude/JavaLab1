package com.jabalab;

public class MyException extends Exception {
    private String message;
    MyException (String message){
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
