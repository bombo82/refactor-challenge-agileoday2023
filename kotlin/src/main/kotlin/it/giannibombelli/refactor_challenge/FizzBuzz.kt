package it.giannibombelli.refactor_challenge

class FizzBuzz : FizzBuzzInterface {
    override fun say(number: Int): String {
        var accumulator = ""

        val fizzDivisor = 3
        val fizzWord = "Fizz"
        val fizzDivisorAndWord = Pair(fizzDivisor, fizzWord)
        if (number % fizzDivisorAndWord.first == 0) {
            accumulator += fizzDivisorAndWord.second
        }

        val buzzDivisor = 5
        val buzzWord = "Buzz"
        val buzzDivisorAndWord = Pair(buzzDivisor, buzzWord)
        if (number % buzzDivisorAndWord.first == 0) {
            accumulator += buzzDivisorAndWord.second
        }

        return accumulator.ifEmpty { number.toString() }
    }
}
