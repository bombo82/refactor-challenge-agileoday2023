package it.giannibombelli.refactor_challenge

class FizzBuzz : FizzBuzzInterface {
    override fun say(number: Int): String {
        var accumulator = ""

        val fizzDivisorAndWord = Pair(3, "Fizz")
        val buzzDivisorAndWord = Pair(5, "Buzz")
        val divisorAndWordList = listOf(fizzDivisorAndWord, buzzDivisorAndWord)
        for (divisorAndWord in divisorAndWordList) {
            if (number % divisorAndWord.first == 0) {
                accumulator += divisorAndWord.second
            }
        }

        return accumulator.ifEmpty { number.toString() }
    }
}
