package it.giannibombelli.refactor_challenge;

public class FizzBuzz implements FizzBuzzInterface {
    @Override
    public String say(int number) {
        String accumulator = "";

        var fizzDivisorAndWord = new DivisorAndWord(3, "Fizz");
        if (number % fizzDivisorAndWord.getDivisor() == 0) {
            accumulator += fizzDivisorAndWord.getWord();
        }
        var buzzDivisorAndWord = new DivisorAndWord(5, "Buzz");
        if (number % buzzDivisorAndWord.getDivisor() == 0) {
            accumulator += buzzDivisorAndWord.getWord();
        }

        if (!accumulator.isEmpty()) {
            return accumulator;
        }

        return String.valueOf(number);

    }
}
