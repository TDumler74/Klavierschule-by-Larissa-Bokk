package de.ait.ksdemo.validation.constraints;

import de.ait.ksdemo.validation.validators.DayOfWeekValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 05.11.2023
 * ks-demo
 *
 * @author Tatjana Dumler
 **/

@Target(ElementType.FIELD) // хотим, чтобы аннотацию можно было вешать только на поля
@Retention(RetentionPolicy.RUNTIME) // мы хотим, чтобы после компиляции и запуска аннотация никуда не исчезала
@Constraint(validatedBy = DayOfWeekValidator.class)
public @interface DayOfWeek {

    String message() default "must be day of week"; // сообщение, которое получит пользователь при ошибке

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
