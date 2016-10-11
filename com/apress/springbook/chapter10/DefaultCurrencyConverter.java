package com.apress.springbook.chapter10;

public class DefaultCurrencyConverter implements CurrencyConverter {
  private ExchangeRateService exchangeRateService;

  public void setExchangeRateService(ExchangeRateService exchangeRateService) {
    this.exchangeRateService = exchangeRateService;
  }

  public double convert(double amount, String fromCurrency, String toCurrency)
   throws UnknownCurrencyException {
    // get the currect exchange rate for the specified currencies
    double exchangeRate = 
      exchangeRateService.getExchangeRate(fromCurrency, toCurrency);
    // return the amount multiplied with the exchange rate
    return amount * exchangeRate;
  }
}
