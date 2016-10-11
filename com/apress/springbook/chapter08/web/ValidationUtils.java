package com.apress.springbook.chapter08.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

public class ValidationUtils {
    
    public static final String MSG_TOO_LONG = "errors.too-long";
    public static final String MSG_REQUIRED = "errors.required";
    public static final String MSG_BOUNDS = "errors.value-between";

    public static boolean rejectIfLengthGreaterThan(int maxLength, String fieldName,
            Errors errors) {
        Object value = errors.getFieldValue(fieldName);
        if (value != null && value.toString().length() > maxLength) {
            errors.rejectValue(fieldName, MSG_TOO_LONG,
                new Object[]{msr(fieldName,errors), new Integer(maxLength)},
                "Field " + fieldName +
                    " must not be greater than " + maxLength + " characters");
            return false;
        }
        return true;
    }

private static Object msr(String fieldName, Errors errors) {
  List<String> fieldNames = new ArrayList<String>();
  fieldName = errors.getNestedPath() + fieldName;
  fieldNames.add(fieldName);
  int index = -1;
  while ((index = fieldName.indexOf('.')) > -1) {
    fieldName = fieldName.substring(index+1);
    fieldNames.add(fieldName);
  }
  return new DefaultMessageSourceResolvable(
         fieldNames.toArray(new String[fieldNames.size()]));
}


    public static boolean rejectIfEmpty(String field, Errors errors) {
      Object value = errors.getFieldValue(field);
      if (!StringUtils.hasLength(value.toString())) {
        errors.rejectValue(field, MSG_REQUIRED, new Object[]{
            msr(field,errors)}, "Field " + field + " is required");
        return false;
      }
      return true;
    }

    public static boolean rejectIfNotBetweenInclusive (int lower, int upper, String field, Errors errors) {
	int value = Integer.parseInt(errors.getFieldValue(field).toString());
	if(value < lower || value > upper) {
            errors.rejectValue(field, MSG_BOUNDS, new Object[]{
                    msr(field,errors), new Integer(lower), new Integer(upper)}, "Field " + field + " must be between "  + lower + " and " + upper);
	    return false;
	}
	return true;
    }

}
