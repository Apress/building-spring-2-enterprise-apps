package com.apress.springbook.chapter10;

import junit.framework.TestCase;

import org.easymock.EasyMock;

public class DefaultCurrencyConverterTests extends TestCase {
   private DefaultCurrencyConverter converter;

   private ExchangeRateService exchangeRateService;

   public DefaultCurrencyConverterTests(String name) {
      super(name);
   }

   protected void setUp() throws Exception {
      converter = new DefaultCurrencyConverter();

      exchangeRateService = EasyMock.createMock(ExchangeRateService.class);
      converter.setExchangeRateService(exchangeRateService);
   }

   // tests go here ...
public void testConvertWithValidInput() throws UnknownCurrencyException {
  EasyMock.expect(exchangeRateService.getExchangeRate("EUR", "USD"))
         .andReturn(1.2).times(2);

  EasyMock.replay(exchangeRateService);

  assertEquals(12.0, converter.convert(10.0, "EUR", "USD"));
  assertEquals(24.0, converter.convert(20.0, "EUR", "USD"));

  EasyMock.verify(exchangeRateService);
}

public void testConvertWithUnknownCurrency() throws UnknownCurrencyException {
  EasyMock.expect(exchangeRateService.getExchangeRate(
         (String)EasyMock.isA(String.class), (String)EasyMock.isA(String.class)))
         .andThrow(new UnknownCurrencyException()).times(2);

  EasyMock.replay(exchangeRateService);

  try {
    converter.convert(10.0, "EUR", "-UNKNOWN-");
    fail("an unknown currency exception was expected");
  } catch (UnknownCurrencyException e) {
    // do nothing, was expected
  }

  try {
    converter.convert(10.0, "-UNKNOWN-", "EUR");
    fail("an unknown currency exception was expected");
  } catch (UnknownCurrencyException e) {
    // do nothing, was expected
  }

  EasyMock.verify(exchangeRateService);
}


}
