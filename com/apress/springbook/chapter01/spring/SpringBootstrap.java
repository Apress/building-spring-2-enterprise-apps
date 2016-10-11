/*
package com.apress.springbook.chapter01.spring;

public class SpringBootstrap {
  public static void main(String[] args) throws Exception {


  }
}
*/
package com.apress.springbook.chapter01.spring;

import java.io.FileInputStream;
import java.util.Properties;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

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
      XmlBeanFactory factory = 
        new XmlBeanFactory(new FileSystemResource(args[0]));

      /* Pause the application until a key is pressed */
      System.out.println("Press any key to close the application");
      System.in.read();

      /* Key has been pressed; close the application and exit */
  }
}
