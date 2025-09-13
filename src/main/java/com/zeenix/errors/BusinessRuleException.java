package com.zeenix.errors;

public class BusinessRuleException extends Exception {
  public BusinessRuleException(String message) {
    super(message);
  }
}