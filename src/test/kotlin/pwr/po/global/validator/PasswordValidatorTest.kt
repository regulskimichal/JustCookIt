package pwr.po.global.validator

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PasswordValidatorTest {
    private var validPasswords: List<String> = PasswordFactory.validPasswords
    private var nonValidPasswords: List<String> = PasswordFactory.nonValidPasswords
    private var passwordValidator: PasswordValidator = PasswordValidator()

    @BeforeEach
    fun setUp() {
        validPasswords = PasswordFactory.validPasswords
        nonValidPasswords = PasswordFactory.nonValidPasswords
        passwordValidator = PasswordValidator()
    }

    @Test
    fun shouldBeValidPassword() {
        validPasswords.forEach { assertTrue(passwordValidator.isValid(it, null)) }
    }

    @Test
    fun shouldNotBeValidPassword() {
        nonValidPasswords.forEach { assertFalse(passwordValidator.isValid(it, null)) }
    }
}