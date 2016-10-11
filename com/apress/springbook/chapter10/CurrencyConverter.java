package com.apress.springbook.chapter10;

public interface CurrencyConverter {
  double convert(double amount, String fromCurrency, String toCurrency)
    throws UnknownCurrencyException;
} 
