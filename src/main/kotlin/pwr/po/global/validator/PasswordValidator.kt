package pwr.po.global.validator

import pwr.po.global.annotation.Password
import java.util.regex.Pattern
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

class PasswordValidator : ConstraintValidator<Password, CharSequence> {

    override fun initialize(constraintAnnotation: Password?) = Unit

    override fun isValid(value: CharSequence, context: ConstraintValidatorContext?): Boolean =
            PATTERN.matcher(value).matches()

    companion object {
        private val REGEXP = "^[\\p{IsLatin}\\p{Punct}0-9]{8,}$"
        private val PATTERN = Pattern.compile(REGEXP)
    }
}
