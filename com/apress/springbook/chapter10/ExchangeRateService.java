package com.apress.springbook.chapter10;

public interface ExchangeRateService {
  double getExchangeRate(String fromCurrency, String toCurrency)
   throws UnknownCurrencyException;
}
