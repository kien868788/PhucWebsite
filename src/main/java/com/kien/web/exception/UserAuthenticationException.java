package com.kien.web.exception;

public class UserAuthenticationException extends RuntimeException{
    public UserAuthenticationException() {
        super("Không đăng nhập được!");
    }
}
