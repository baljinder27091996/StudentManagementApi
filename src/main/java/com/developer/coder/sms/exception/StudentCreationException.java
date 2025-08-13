package com.developer.coder.sms.exception;

public class StudentCreationException extends RuntimeException {
    public StudentCreationException(String message) {
      super(message);
    }

    public StudentCreationException(String message, Throwable cause) {
      super(message, cause);
    }
  }