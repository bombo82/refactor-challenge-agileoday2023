package it.giannibombelli.refactor_challenge

class FizzBuzz : FizzBuzzInterface {
    override fun say(number: Int): String {
        val divisorAndWordList = listOf(
            Pair(3, "Fizz"),
            Pair(5, "Buzz")
        )

        var accumulator = ""
        for (divisorAndWord in divisorAndWordList) {
            if (number % divisorAndWord.first == 0) {
                accumulator += divisorAndWord.second
            }
        }

        return accumulator.ifEmpty { number.toString() }
    }
}
