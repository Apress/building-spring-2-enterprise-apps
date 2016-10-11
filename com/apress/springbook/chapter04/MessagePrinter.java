package com.apress.springbook.chapter04;

import org.aspectj.lang.ProceedingJoinPoint;

public class MessagePrinter {
   public void printMessageToInformMatchStarts() {
      System.out.println("Attempting to start tennis match!");
   }

  public void printMessageToInformMatchHasStarted(Match match) {
    System.out.println("This match has been started: " + match);
  }

  public void printMessageWhenMatchIdentifierIsNotFound(UnknownMatchException exception) 
  {
    System.out.println("No match found for match identifier " 
            + exception.getInvalidMatchIdentifier());
  }

  public void printMessageWhenStartMatchAttemptIsOver() {
    System.out.println("Tried to start a match and this attempt is now over!");
  }

  public Object controlStartMatchMethodExecution(ProceedingJoinPoint pjp)
        throws Throwable {
    System.out.println("A match is about to be started!");

    try {
      Object result = pjp.proceed();
      System.out.println("The match has been started successfully!");
      return result;
    } catch (Throwable t) {
      System.out.println("Oops, something went wrong while starting the match.");
      throw t;
    }
  }


}
