package com.apress.springbook.chapter01.test;

import com.apress.springbook.chapter01.swing_application.SwingApplication;

public class LaunchTheSwingApplication {
  public static void main(String[] args) {
    new SwingApplication(new StubTournamentMatchManager());
  }
}
