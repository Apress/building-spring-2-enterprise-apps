package com.apress.springbook.chapter02;

import junit.framework.TestCase;

import org.springframework.core.io.ClassPathResource;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

public class BeanFactoryPreInstantiateSingletonsIntegrationTests extends TestCase {
   public void testPreInstantiateSingletons() {
      ConfigurableListableBeanFactory beanFactory =
         new XmlBeanFactory(
            new ClassPathResource(
               "com/apress/springbook/chapter02/preInstantiate-singletons.xml"
            )
         );

      assertEquals(0, InstantiationCounterClass.getNumberOfInstantiations());

      beanFactory.preInstantiateSingletons();

      assertEquals(1, InstantiationCounterClass.getNumberOfInstantiations());
   }
}

