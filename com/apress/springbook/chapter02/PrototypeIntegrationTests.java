package com.apress.springbook.chapter02;

import junit.framework.TestCase;

import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

public class PrototypeIntegrationTests extends TestCase {
   public void testPreInstantiateSingletons() {
      BeanFactory beanFactory =
         new XmlBeanFactory(
            new ClassPathResource(
               "com/apress/springbook/chapter02/prototype.xml"
            )
         );

      PrimeIterator primeNumber1 = (PrimeIterator)
            beanFactory.getBean("primeIterator");
      PrimeIterator primeNumber2 = (PrimeIterator)
            beanFactory.getBean("primeIterator");

      assertNotSame(primeNumber1, primeNumber2);
   }
}
