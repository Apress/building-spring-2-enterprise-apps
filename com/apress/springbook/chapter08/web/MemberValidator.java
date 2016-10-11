package com.apress.springbook.chapter08.web;

import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import com.apress.springbook.chapter08.domain.Member;

import static com.apress.springbook.chapter08.web.ValidationUtils.rejectIfEmpty;
import static com.apress.springbook.chapter08.web.ValidationUtils.rejectIfNotBetweenInclusive;

public class MemberValidator implements Validator {
    
  private Validator nameValidator = new NameValidator();
  private Validator phoneNumberValidator = new PhoneNumberValidator();
  private Validator addressValidator = new AddressValidator();

  public boolean supports(Class clazz) {
    return Member.class.isAssignableFrom(clazz);
  }

  public void validate(Object obj, Errors errors) {
    Member player = (Member) obj;
    errors.pushNestedPath("name");
    nameValidator.validate(player.getName(), errors);
    errors.popNestedPath();
       
    for (int i = 0; i < player.getPhoneNumbers().size(); i++) {
      errors.pushNestedPath("phoneNumbers["+i+"]");
      phoneNumberValidator.validate(player.getPhoneNumbers().get(i), errors);
      errors.popNestedPath();
    }
        
    errors.pushNestedPath("address");
    addressValidator.validate(player.getAddress(), errors);
    errors.popNestedPath();

    if (rejectIfEmpty("age", errors)) {
      rejectIfNotBetweenInclusive (18, 120, "age", errors);
    }
  }
}
