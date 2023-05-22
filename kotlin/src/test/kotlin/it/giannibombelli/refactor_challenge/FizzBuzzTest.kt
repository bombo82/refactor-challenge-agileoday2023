package it.giannibombelli.refactor_challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FizzBuzzTest {

    @Test
    internal fun `no match`() {
        val fizzBuzz = FizzBuzz(listOf(
            DivisorAndWord(3, "Fizz"),
            DivisorAndWord(5, "Buzz")
        ))
        assertEquals("1", fizzBuzz.say(1))
        assertEquals("2", fizzBuzz.say(2))
    }

    @Test
    internal fun `simple match`() {
        val fizzBuzz = FizzBuzz(listOf(
            DivisorAndWord(3, "Fizz"),
            DivisorAndWord(5, "Buzz")
        ))
        assertEquals("Fizz", fizzBuzz.say(3))
        assertEquals("Buzz", fizzBuzz.say(5))
    }

    @Test
    internal fun `multiple match`() {
        val fizzBuzz = FizzBuzz(listOf(
            DivisorAndWord(3, "Fizz"),
            DivisorAndWord(5, "Buzz")
        ))
        assertEquals("FizzBuzz", fizzBuzz.say(15))
    }
}
