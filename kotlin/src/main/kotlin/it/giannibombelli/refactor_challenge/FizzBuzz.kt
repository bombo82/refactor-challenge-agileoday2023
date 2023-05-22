package it.giannibombelli.refactor_challenge

class FizzBuzz(
    private val divisorAndWordList: List<Pair<Int, String>> = listOf(
        Pair(3, "Fizz"),
        Pair(5, "Buzz")
    )
) : FizzBuzzInterface {
    override fun say(number: Int): String {

        var accumulator = ""
        for (divisorAndWord in divisorAndWordList) {
            if (number % divisorAndWord.first == 0) {
                accumulator += divisorAndWord.second
            }
        }

        return accumulator.ifEmpty { number.toString() }
    }
}
