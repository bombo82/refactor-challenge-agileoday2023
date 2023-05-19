package it.giannibombelli.refactor_challenge;

import java.util.HashMap;
import java.util.Map;

public class FizzBuzz implements FizzBuzzInterface {
    @Override
    public String say(int number) {
        String accumulator = "";

        if (number % 3 == 0 && number % 5 ==0) {
            return "Fizz" + "Buzz";
        }
        if (number % 3 == 0) {
            return "Fizz";
        }
        if (number % 5 == 0) {
            return "Buzz";
        }

        if (!accumulator.isEmpty()) {
            return accumulator;
        }

        return String.valueOf(number);

    }
}
