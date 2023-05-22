package it.giannibombelli.refactor_challenge

class FizzBuzz(
    private val divisorAndWordList: List<DivisorAndWord> = listOf(
        DivisorAndWord(3, "Fizz"),
        DivisorAndWord(5, "Buzz")
    )
) : FizzBuzzInterface {
    override fun say(number: Int): String {

        var accumulator = ""
        for (divisorAndWord in divisorAndWordList) {
            accumulator += getWordOrEmpty(number, divisorAndWord)
        }

        return accumulator.ifEmpty { number.toString() }
    }

    private fun getWordOrEmpty(number: Int, divisorAndWord: DivisorAndWord) =
        if (number % divisorAndWord.divisor == 0) {
            divisorAndWord.word
        } else {
            ""
        }
}
