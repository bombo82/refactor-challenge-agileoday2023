package it.giannibombelli.refactor_challenge;

public class FizzBuzz implements FizzBuzzInterface {
    @Override
    public String say(int number) {
        String accumulator = "";

        var fizzDivisorAndWord = new DivisorAndWord(3, "Fizz");
        if (number % fizzDivisorAndWord.getDivisor() == 0) {
            accumulator += fizzDivisorAndWord.getWord();
        }
        if (number % 5 == 0) {
            accumulator += "Buzz";
        }

        if (!accumulator.isEmpty()) {
            return accumulator;
        }

        return String.valueOf(number);

    }
}
