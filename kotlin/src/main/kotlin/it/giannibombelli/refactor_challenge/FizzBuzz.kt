package it.giannibombelli.refactor_challenge

class FizzBuzz : FizzBuzzInterface {
    override fun say(number: Int): String {
        var accumulator = ""
        if (number % 3 == 0) {
            accumulator += "Fizz"
        }
        if (number % 5 == 0) {
            accumulator += "Buzz"
        }

        if (accumulator.isNotEmpty()) {
            return accumulator
        } else {
            return number.toString()
        }
    }
}
