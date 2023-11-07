package de.ait.ksdemo.validation.validators;

import de.ait.ksdemo.validation.constraints.DayOfWeek;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 05.11.2023
 * ks-demo
 *
 * @author Tatjana Dumler
 **/

public class DayOfWeekValidator implements ConstraintValidator<DayOfWeek, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        for (java.time.DayOfWeek dayOfWeek : java.time.DayOfWeek.values()) {
            if (dayOfWeek.name().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
