package com.apress.springbook.chapter10;

public class DefaultExchangeRateService implements ExchangeRateService {
    public double getExchangeRate(String fromCurrency, String toCurrency) throws UnknownCurrencyException {
	if (toCurrency.equals("-UNKNOWN-")) {
	    throw new UnknownCurrencyException();
	}
	return 1.2234;
    }
}
