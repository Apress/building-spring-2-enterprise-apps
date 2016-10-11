package com.apress.springbook.chapter04;

public class MessagePrintingXmlAspectIntegrationTests extends
     MessagePrintingAspectIntegrationTests {

  protected String[] getConfigLocations() {
    return new String[] {
      "classpath:com/apress/springbook/chapter04/" +
         "xml-aspect-context.xml"
    };
  }
}
