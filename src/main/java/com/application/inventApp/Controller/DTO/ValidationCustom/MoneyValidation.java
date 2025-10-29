package com.application.inventApp.Controller.DTO.ValidationCustom;

import java.math.BigDecimal;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MoneyValidation implements ConstraintValidator<MoneyValid, BigDecimal> {

  @Override
  public boolean isValid(BigDecimal bigDecimal, ConstraintValidatorContext constraintValidatorContext) {
    if (bigDecimal == null) {
      return false;
    }
    Pattern pattern = Pattern.compile("^(\\d{1,3}(\\.\\d{3})*|\\d{1,3})(,\\d{1,2})?$");
    String value = bigDecimal.toString();
    return pattern.matcher(value).matches();
  }
}
