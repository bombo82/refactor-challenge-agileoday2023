package it.giannibombelli.refactor_challenge

class DivisorAndWord(val divisor: Int, val word: String) {
    fun getWordOrEmpty(number: Int, divisorAndWord: DivisorAndWord) =
        if (number % divisorAndWord.divisor == 0) {
            divisorAndWord.word
        } else {
            ""
        }
}
