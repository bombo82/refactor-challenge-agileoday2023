package it.giannibombelli.refactor_challenge

class DivisorAndWord(val divisor: Int, val word: String) {
    fun getWordOrEmpty(number: Int) =
        if (number % divisor == 0) {
            word
        } else {
            ""
        }
}
