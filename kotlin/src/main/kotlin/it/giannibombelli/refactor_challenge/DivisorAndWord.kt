package it.giannibombelli.refactor_challenge

class DivisorAndWord(private val divisor: Int, private val word: String) {
    fun getWordOrEmpty(number: Int): String = if (number % divisor == 0) word else ""
}
