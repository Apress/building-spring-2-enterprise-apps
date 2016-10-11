package com.apress.springbook.chapter02;

import java.io.FileInputStream;
import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.ClassPathResource;

public class SpringBootstrap {
    public static void main(String[] args) throws Exception {

        /* Check if the location of the configuration file has been passed
         * as an argument.
         */
        if (args.length == 0) {
	  throw new IllegalArgumentException("Please provide the location of a " +
	          "Spring configuration file as argument!");
        }

        /* Call the Spring Framework API here! */
        BeanFactory beanFactory = 
	  new XmlBeanFactory(new FileSystemResource(args[0]));

	/*
	BeanFactory beanFactory =
	    new XmlBeanFactory(new ClassPathResource("com/apress/springbook/chapter02/application-context.xml"));
	*/
	//Player player = (Player)beanFactory.getBean("Justine", Player.class);
	

	//System.out.println("Bean property value: " + player.getFullName());

	PropertyEditorTestBean testBean = (PropertyEditorTestBean)beanFactory.getBean("testBean");

        /* pause the application until a key is pressed */
        System.out.println("Press any key to close the application");
        System.in.read();

        /* Key has been pressed, close the application and exit */
    }
}
