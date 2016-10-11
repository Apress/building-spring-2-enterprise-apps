/*package com.apress.springbook.chapter01.swing_application;

import org.apache.commons.dbcp.BasicDataSource;

import com.apress.springbook.chapter01.Match;
import com.apress.springbook.chapter01.jdbc.JdbcMatchDao;
import com.apress.springbook.chapter01.DefaultTournamentMatchManager;

public class SwingApplication {
    private TournamentMatchManager tournamentMatchManager;

    public SwingApplication(TournamentMatchManager tournamentMatchManager) {
        this.tournamentMatchManager = tournameMatchManager;

    }

    public static void main(String[] args) throws Exception {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(System.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(System.getProperty("jdbc.url"));
        dataSource.setUsername(System.getProperty("jdbc.username"));
        dataSource.setPassword("pass");

        JdbcMatchDao matchDao = new JdbcMatchDao();
        matchDao.setDataSource(dataSource);

        DefaultTournamentMatchManager tournamentMatchManager =
            new DefaultTournamentMatchManager();
        tournamentMatchManager.setMatchDao(matchDao);

        new SwingApplication(tournamentMatchManager);
    }
}
*/
/*
package com.apress.springbook.chapter01.swing_application;

import org.apache.commons.dbcp.BasicDataSource;

import com.apress.springbook.chapter01.Match;
import com.apress.springbook.chapter01.jdbc.JdbcMatchDao;
import com.apress.springbook.chapter01.TournamentMatchManager;
import com.apress.springbook.chapter01.DefaultTournamentMatchManager;

public class SwingApplication {
    private TournamentMatchManager tournamentMatchManager;

    public SwingApplication(TournamentMatchManager tournamentMatchManager) {
        this.tournamentMatchManager = tournamentMatchManager;
*/
        /* other code is omitted for brevity */
/*
    }

    public static void main(String[] args) throws Exception {
        BasicDataSource dataSource = new BasicDataSource();
*/
        /* Setting the properties of the data source. */
/*
        dataSource.setDriverClassName(System.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(System.getProperty("jdbc.url"));
        dataSource.setUsername(System.getProperty("jdbc.username"));
        dataSource.setPassword("pass");

        JdbcMatchDao matchDao = new JdbcMatchDao();
        matchDao.setDataSource(dataSource);

        DefaultTournamentMatchManager tournamentMatchManager =
            new DefaultTournamentMatchManager();
        tournamentMatchManager.setMatchDao(matchDao);

        new SwingApplication(tournamentMatchManager);
    }

}
*/
package com.apress.springbook.chapter01.swing_application;

import javax.sql.DataSource;

import javax.naming.Context;
import javax.naming.InitialContext;

import java.util.Hashtable;

import com.apress.springbook.chapter01.Match;
import com.apress.springbook.chapter01.jdbc.JdbcMatchDao;
import com.apress.springbook.chapter01.TournamentMatchManager;
import com.apress.springbook.chapter01.DefaultTournamentMatchManager;

public class SwingApplication {
  private TournamentMatchManager tournamentMatchManager;

  public SwingApplication(TournamentMatchManager tournamentMatchManager) {
    this.tournamentMatchManager = tournamentMatchManager;

    /* other code is omitted for brevity */
  }

  public static void main(String[] args) throws Exception {
    Hashtable properties = new Hashtable();
    properties.put(Context.INITIAL_CONTEXT_FACTORY,
        "weblogic.jndi.WLInitialContextFactory");
    properties.put(Context.PROVIDER_URL,
        "t3://localhost:7001");
    Context ctx = new InitialContext(properties);
    DataSource dataSource = (DataSource)ctx.lookup("env:jdbc/myDataSource");

    JdbcMatchDao matchDao = new JdbcMatchDao();
    matchDao.setDataSource(dataSource);

    DefaultTournamentMatchManager tournamentMatchManager =
      new DefaultTournamentMatchManager();
    tournamentMatchManager.setMatchDao(matchDao);

    new SwingApplication(tournamentMatchManager);
  }
}
