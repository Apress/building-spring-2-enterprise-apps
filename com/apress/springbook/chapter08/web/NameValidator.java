package com.apress.springbook.chapter08.web;

import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import com.apress.springbook.chapter08.domain.Name;

import static com.apress.springbook.chapter08.web.ValidationUtils.rejectIfEmpty;
import static com.apress.springbook.chapter08.web.ValidationUtils.rejectIfLengthGreaterThan;

public class NameValidator implements Validator {

  public boolean supports(Class clazz) {
    return Name.class.isAssignableFrom(clazz);
  }

  public void validate(Object obj, Errors errors) {
    if (rejectIfEmpty("first", errors)) {
      rejectIfLengthGreaterThan (255, "first", errors);
    }
    if (rejectIfEmpty("last", errors)) {
      rejectIfLengthGreaterThan(255, "last", errors);
    }
    rejectIfLengthGreaterThan(255, "middle", errors);
  }
}
