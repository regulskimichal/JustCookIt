package pwr.po.global.validator

object PasswordFactory {
    val validPasswords = listOf(
            "Password",
            "SecondPassword",
            "12345678",
            "123456qwerty",
            "1QaZxSw@3EdC",
            "!@#$%^&*",
            "żźćąśęńółŹĄŚĘŁÓŃ"
    )

    val nonValidPasswords = listOf(
            "1234567",
            "qwertyu",
            " 1234567a",
            " \t\nqwerty"
    )
}