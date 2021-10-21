package ru.digitallegua.examtask.exception;

public class BadModelException extends RuntimeException {

    BadModelException(){
        super();
    }

    public BadModelException(String message){
        super(message);
    }

    BadModelException(String message, Throwable cause){
        super(message,cause);
    }
}
