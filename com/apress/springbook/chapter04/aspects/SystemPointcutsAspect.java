/*package com.apress.springbook.chapter04.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemPointcutsAspect {
  @Pointcut("within(com.apress.springbook.chapter04..*)")
  public void inServiceLayer() {}
}

package com.apress.springbook.chapter04.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemPointcutsAspect {
  @Pointcut("execution(* relax(..)) || execution(* enjoy(..)) || " +
         "execution(* chillOut(..))")
  public void goodTimes() {}
}

package com.apress.springbook.chapter04.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemPointcutsAspect {
  @Pointcut("execution(* do*(..))")
  public void performAction() {}
}

package com.apress.springbook.chapter04.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemPointcutsAspect {
  @Pointcut("execution(* *())")
  public void allMethodsWithoutArguments() {}

  @Pointcut("execution(* *(*))")
  public void allMethodsWithOneArgumentRegarlessOfType() {}

  @Pointcut("execution(* *(java.lang.String))")
  public void allMethodsWithOneArgumentOfTypeString() {}

  @Pointcut("execution(* *(java.lang.String,..))")
  public void allMethodsWithFirstArgumentOfTypeStringAndZeroOrMoreOtherArguments() {}
   
  @Pointcut("execution(* *(*,java.lang.String,..))")
  public void allMethodsWithSecondArgumentOfTypeStringAndZeroOrMoreOtherArguments() {}
}

package com.apress.springbook.chapter04.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemPointcutsAspect {
    //  @Pointcut("@annotation(com.apress.springbook.chapter04.Audit)")
    //public void auditableMethods() {}

      @Pointcut("@within(com.apress.springbook.chapter04.Audit)")
      public void auditableMethods() {}

}
*/

package com.apress.springbook.chapter04.aspects;

import com.apress.springbook.chapter04.Audit;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemPointcutsAspect {
    //  @Pointcut("@annotation(audit)")
  @Pointcut("@within(audit)")
  public void auditableMethods(Audit audit) {}
}

