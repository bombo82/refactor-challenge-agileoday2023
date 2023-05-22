package it.giannibombelli.refactor_challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class FizzBuzzTest {

    @ParameterizedTest
    @CsvSource("1, 1", "1, 1")
    internal fun `no match`(number: Int, expected: String) {
        val fizzBuzz = FizzBuzz(
            listOf(
                DivisorAndWord(3, "Fizz"),
                DivisorAndWord(5, "Buzz")
            )
        )
        assertEquals(expected, fizzBuzz.say(number))
    }

    @ParameterizedTest
    @CsvSource("3, Fizz", "5, Buzz")
    internal fun `simple match`(number: Int, expected: String) {
        val fizzBuzz = FizzBuzz(
            listOf(
                DivisorAndWord(3, "Fizz"),
                DivisorAndWord(5, "Buzz")
            )
        )
        assertEquals(expected, fizzBuzz.say(number))
    }

    @ParameterizedTest
    @CsvSource("15, FizzBuzz", "21, FizzBang", "35, BuzzBang", "105, FizzBuzzBang")
    internal fun `multiple match`(number: Int, expected: String) {
        val fizzBuzz = FizzBuzz(
            listOf(
                DivisorAndWord(3, "Fizz"),
                DivisorAndWord(5, "Buzz"),
                DivisorAndWord(7, "Bang")
            )
        )
        assertEquals(expected, fizzBuzz.say(number))
    }
}
