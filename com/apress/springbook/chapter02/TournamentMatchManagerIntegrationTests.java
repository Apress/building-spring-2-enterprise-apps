package com.apress.springbook.chapter02;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class TournamentMatchManagerIntegrationTests extends AbstractDependencyInjectionSpringContextTests {

    protected String[] getConfigLocations() {
       return new String[] {
          "classpath:com/apress/springbook/chapter02/application-context.xml"
       };
    }

    private TournamentMatchManager tournamentMatchManager;

    public void setTournamentMatchManager(TournamentMatchManager tmm) {
      this.tournamentMatchManager = tmm;
    }

    public void testCreateMatch() throws Exception {
      Match match = this.tournamentMatchManager.startMatch(2000);
    }
}
