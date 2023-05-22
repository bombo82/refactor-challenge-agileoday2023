package it.giannibombelli.refactor_challenge

class FizzBuzz : FizzBuzzInterface {
    override fun say(number: Int): String {
        if (number % 3 == 0 && number % 5 == 0) {
            return "Fizz" + "Buzz"
        }

        var accumulator = ""
        if (number % 3 == 0) {
            return "Fizz"
        }
        if (number % 5 == 0) {
            return "Buzz"
        }

        if (accumulator.isNotEmpty()) {
            return accumulator
        }
        return number.toString()
    }
}
