package it.giannibombelli.refactor_challenge

class FizzBuzz : FizzBuzzInterface {
    override fun say(number: Int): String {
        var accumulator = ""

        val fizzDivisorAndWord = Pair(3, "Fizz")
        val divisorAndWordList = listOf(fizzDivisorAndWord)
        for (divisorAndWord in divisorAndWordList) {
            if (number % fizzDivisorAndWord.first == 0) {
                accumulator += fizzDivisorAndWord.second
            }
        }

        val buzzDivisorAndWord = Pair(5, "Buzz")
        if (number % buzzDivisorAndWord.first == 0) {
            accumulator += buzzDivisorAndWord.second
        }

        return accumulator.ifEmpty { number.toString() }
    }
}
