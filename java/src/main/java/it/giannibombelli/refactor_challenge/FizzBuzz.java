package it.giannibombelli.refactor_challenge;

import java.util.Arrays;
import java.util.List;

public class FizzBuzz implements FizzBuzzInterface {

    private final List<DivisorAndWord> divisorAndWordList;

    public FizzBuzz() {
        divisorAndWordList = Arrays.asList(
                new DivisorAndWord(3, "Fizz"),
                new DivisorAndWord(5, "Buzz"));
    }

    @Override
    public String say(int number) {
        String accumulator = "";

        for (var divisorAndWord : divisorAndWordList) {
            if (number % divisorAndWord.getDivisor() == 0) {
                accumulator += divisorAndWord.getWord();
            }
        }

        if (!accumulator.isEmpty()) {
            return accumulator;
        }

        return String.valueOf(number);

    }
}
