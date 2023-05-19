package it.giannibombelli.refactor_challenge;

public class FizzBuzz implements FizzBuzzInterface {
    @Override
    public String say(int number) {
        String accumulator = "";

        if (number % 3 == 0) {
            accumulator += "Fizz";
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
