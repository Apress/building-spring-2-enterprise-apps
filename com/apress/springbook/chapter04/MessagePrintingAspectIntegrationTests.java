package com.apress.springbook.chapter04;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class MessagePrintingAspectIntegrationTests extends
      AbstractDependencyInjectionSpringContextTests {
   
  protected String[] getConfigLocations() {
    return new String[] {
      "classpath:com/apress/springbook/chapter04/" +
        "aspect-config.xml"
    };
  }

  private TournamentMatchManager tournamentMatchManager;

  public void setTournamentMatchManager(
            TournamentMatchManager tournamentMatchManager) {
    this.tournamentMatchManager = tournamentMatchManager;
  }

  public void testCallStartMatchMethodOnBeanFromContainer() throws Exception {
    System.out.println("=== GOING TO CALL METHOD " + 
            "ON BEAN FROM CONTAINER ===");

    this.tournamentMatchManager.startMatch(1);

    System.out.println("=== FINISHED CALLING METHOD " + 
            "ON BEAN FROM CONTAINER ===");      
  }

  public void testCallStartMatchMethodOnNewlyCreatedObject() throws Exception {
    TournamentMatchManager newTournamentMatchManager =
       new DefaultTournamentMatchManager();

    System.out.println("=== GOING TO CALL METHOD " + 
            "ON NEWLY CREATED OBJECT ===");
      
    newTournamentMatchManager.startMatch(1);

    System.out.println("=== FINISHED CALLING METHOD " + 
            "ON NEWLY CREATED OBJECT ===");
  }
}
