package it.giannibombelli.refactor_challenge;

import java.util.ArrayList;
import java.util.Arrays;

public class FizzBuzz implements FizzBuzzInterface {
    @Override
    public String say(int number) {
        String accumulator = "";

        var fizzDivisorAndWord = new DivisorAndWord(3, "Fizz");
        var divisorAndWordList = Arrays.asList(fizzDivisorAndWord);
        for (var divisorAndWord : divisorAndWordList) {
            if (number % divisorAndWord.getDivisor() == 0) {
                accumulator += divisorAndWord.getWord();
            }
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
