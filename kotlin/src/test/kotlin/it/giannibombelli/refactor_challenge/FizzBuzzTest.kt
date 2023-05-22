package it.giannibombelli.refactor_challenge

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FizzBuzzTest {

    @Test
    internal fun simpleNumber() {
        val fizzBuzz = FizzBuzz(listOf(
            DivisorAndWord(3, "Fizz"),
            DivisorAndWord(5, "Buzz")
        ))
        assertEquals("1", fizzBuzz.say(1))
        assertEquals("2", fizzBuzz.say(2))
    }

    @Test
    internal fun fizz() {
        val fizzBuzz = FizzBuzz(listOf(
            DivisorAndWord(3, "Fizz"),
            DivisorAndWord(5, "Buzz")
        ))
        assertEquals("Fizz", fizzBuzz.say(3))
    }

    @Test
    internal fun buzz() {
        val fizzBuzz = FizzBuzz(listOf(
            DivisorAndWord(3, "Fizz"),
            DivisorAndWord(5, "Buzz")
        ))
        assertEquals("Buzz", fizzBuzz.say(5))
    }

    @Test
    internal fun fizzBuzz() {
        val fizzBuzz = FizzBuzz(listOf(
            DivisorAndWord(3, "Fizz"),
            DivisorAndWord(5, "Buzz")
        ))
        assertEquals("FizzBuzz", fizzBuzz.say(15))
    }
}
