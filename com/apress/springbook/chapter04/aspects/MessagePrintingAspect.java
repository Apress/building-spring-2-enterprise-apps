/*package com.apress.springbook.chapter04.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
public class MessagePrintingAspect {

   @Pointcut("execution(* startMatch(..))")
   public void atMatchStart() {}

   @Before("atMatchStart()")
   public void printHowAnnoyedWeAre() {
      System.out.println("Leave it out! Another tennis match!?");
   }

   @Before("atMatchStart()")
   public void printHowExcitedWeAre() {
      System.out.println("Hurray for another tennis match!");
   }

  @Before("execution(* startMatch(..))")
  public void printMessageToInformMatchStarts() {
    System.out.println("Attempting to start tennis match!");
  }

  @AfterReturning("execution(* startMatch(..))")
  public void printMessageWhenTennisMatchHasBeenStartedSuccessfully() {
    System.out.println("Tennis match was started successfully!");
  }

  @AfterThrowing("execution(* startMatch(..))")
  public void printMessageWhenSomethingGoesWrong() {
    System.out.println("Oops, couldn't start the tennis match. " +
         "Something went wrong!");
  }

  @After("execution(* startMatch(..))")
  public void printMessageToConcludeTheTennisMatchStartAttempt() {
    System.out.println("A tennis match start attempt has taken place. " +
          "We haven't been informed about the outcome but we sincerely " +
          "hope everything worked out OK and wish you very nice day!");
  }

  @Around("execution(* startMatch(..))")
  public Object printMessageToTellHowNiceTheLifeOfAnAdviceIs(
          ProceedingJoinPoint pjp) throws Throwable {

    System.out.println("Greetings, Master, how are you today? I'm " +
          "very glad you're passing by today and hope you'll enjoy " + 
          "your visit!");

    try {
      return pjp.proceed();
    } finally {
      System.out.println("Au revoir, Master, I'm sorry you can't stay " + 
           "longer, but I'm sure you'll pay me a visit again. Have a very " + 
           "nice day yourself, sir!");
    }
  }

  @Before("args(java.util.Hashtable)")
  public void printWarningForUsageOfHashtable() {
    System.out.println("Warning: java.util.Hashtable is passed as argument!");
  }

   @Before("execution(* *(..) throws java.lang.IOException)")
   public void printWarningIOExceptionMayBeThrown() {
      System.out.println("Warning: IOException may be thrown. Brace yourselves!");
   }
}
*/

package com.apress.springbook.chapter04.aspects;

import com.apress.springbook.chapter04.Match;
import com.apress.springbook.chapter04.UnknownMatchException;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;

import org.aspectj.lang.JoinPoint;

@Aspect
public class MessagePrintingAspect {

    /*
  @Before("execution(* startMatch(..))")
  public void printMessageToInformMatchStarts(JoinPoint jp) {
    Long matchId = (Long)jp.getArgs()[0];
    System.out.println("Attempting to start tennis match with identifier " + 
            matchId + "!");
  }
    */

  @Before("execution(* startMatch(long,..))")
  public void printMessageToInformMatchStarts(JoinPoint jp) {
    Long matchId = (Long)jp.getArgs()[0];
    System.out.println("Attempting to start tennis match with identifier " + 
            matchId + "!");
  }

  @Before("execution(* startMatch(..)) && args(matchId, ..)")
  public void printMessageToInformMatchStarts(long matchId) {
    System.out.println("Attempting to start tennis match with identifier " + 
            matchId + "!");
  }


  @AfterReturning(
       value = "execution(com.apress.springbook.chapter04.Match" +
            " startMatch(..))",
       returning = "match"
  )
  public void printMessageToInformMatchHasStarted(Match match) {
    System.out.println("This match has been started: " + match);
  }

  @AfterThrowing(
     value = "execution(* startMatch(..) throws " +
        "com.apress.springbook.chapter04." +
        "UnknownMatchException)",
     throwing = "exception"
  )
  public void printMessageWhenMatchIdentifierIsNotFound(
     UnknownMatchException exception) {
    System.out.println("No match found for match identifier " +
        exception.getInvalidMatchIdentifier() + "!");
  }
}
