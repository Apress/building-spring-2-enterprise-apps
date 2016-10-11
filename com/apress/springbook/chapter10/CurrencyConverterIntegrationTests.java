package com.apress.springbook.chapter10;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class CurrencyConverterIntegrationTests 
  extends AbstractDependencyInjectionSpringContextTests {
    
  private CurrencyConverter currencyConverter;

  public void setCurrencyConverter(CurrencyConverter currencyConverter) {
    this.currencyConverter = currencyConverter;
  }

  protected String[] getConfigLocations() {
    return new String[] { "classpath:/applicationContext.xml" };
  }

  public void testWithValidInput() {
      try {
    assertEquals(12.234, currencyConverter.convert(10.0, "EUR", "USD"));
      } catch (UnknownCurrencyException e) {
	  fail("something went wrong in testWithValidInput()");
    }
  }

  public void testConvertWithUnknownCurrency() {
    try {
      currencyConverter.convert(10.0, "EUR", "-UNKNOWN-");
      fail("an unknown currency exception was expected");
    } catch (UnknownCurrencyException e) {
      // do nothing, was expected
    }
  }
}
