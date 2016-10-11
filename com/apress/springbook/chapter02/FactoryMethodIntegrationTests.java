package com.apress.springbook.chapter02;

import junit.framework.TestCase;

import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FactoryMethodIntegrationTests extends TestCase {
   public void testPreInstantiateSingletons() {
      ConfigurableListableBeanFactory beanFactory =
         new XmlBeanFactory(
            new ClassPathResource(
              "com/apress/springbook/chapter02/factory-methods.xml"
            )
         );

      Pattern pattern = (Pattern)beanFactory.getBean("pattern");
      Matcher matcher = pattern.matcher("abc abc abc");
      int matchCount = 0;

      while (matcher.find()) { matchCount++; }

      assertEquals(3, matchCount);
   }
}
