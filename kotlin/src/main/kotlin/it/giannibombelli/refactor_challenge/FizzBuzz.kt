package it.giannibombelli.refactor_challenge

class FizzBuzz(
    private val divisorAndWordList: List<DivisorAndWord> = listOf(
        DivisorAndWord(3, "Fizz"),
        DivisorAndWord(5, "Buzz")
    )
) : FizzBuzzInterface {
    override fun say(number: Int): String = divisorAndWordList
        .joinToString("") { it.getWordOrEmpty(number) }
        .ifEmpty { number.toString() }
}
