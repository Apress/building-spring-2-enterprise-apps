package com.apress.springbook.chapter02;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

public class PropertyEditorTestBeanIntegrationTests
  extends TestCase {

  private static BeanFactory beanFactory = new XmlBeanFactory(
    new ClassPathResource(
        "com/apress/springbook/chapter02/property-editor-test-bean-tests.xml"
      )
    );

  private static PropertyEditorTestBean testBean;

  static {
    testBean = (PropertyEditorTestBean)beanFactory.getBean("testBean");
  }

  public void testMyNumber() {
    assertEquals(500, testBean.getMyNumber());
  }

  public void testMyToggle() {
    assertFalse(testBean.isMyToggle());
  }

  public void testMyBytes() {
    assertTrue(Arrays.equals("some bytes".getBytes(), testBean.getMyBytes()));
  }

  public void testMyStrings() {
    assertTrue(
      Arrays.equals(
        new String[]{
          "Bram",
          "Mark",
          "Seth",
          "Steven"
        },
        testBean.getMyStrings()
      )
    );
  }

  public void testMyAmount() {
    assertEquals(new BigDecimal("1000000"), testBean.getMyAmount());
  }

  public void testMyClass() {
    assertEquals(Collection.class, testBean.getMyClass());
  }

  public void testMyFile() {
    assertEquals(new File("placeholder.txt"), testBean.getMyFile());
  }

  public void testMyInputStream() throws IOException {
    String content = IOUtils.toString(testBean.getMyInputStream());
    assertTrue(StringUtils.hasText("Google"));
    testBean.getMyInputStream().close();
  }

  public void testMyProperties() {
    Properties myProps = testBean.getMyProperties();
    assertEquals("Steven", myProps.getProperty("firstname"));
    assertEquals("Devijver", myProps.getProperty("lastname"));
  }

  public void testMyUrl() throws MalformedURLException {
    assertEquals(new URL("http://del.icio.us"), testBean.getMyUrl());
  }
}
