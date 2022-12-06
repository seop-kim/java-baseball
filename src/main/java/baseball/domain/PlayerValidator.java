package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerValidator {

    private List<Integer> numbers = new ArrayList<>();
    private String data;
    private int[] numberArr;

    // game, retry validator

    public List<Integer> gameValidation(String data) {
        inputLengthValidation();
        inputNumberValidation();
        inputToNumberArr();
        numberArrValidation();
        numberArrToNumbers();
        numbersValidation();
        return null;
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

    private void inputLengthValidation() {
        if (data.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void inputNumberValidation() {
        try {
            Integer.parseInt(data);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private void inputToNumberArr() {
        numberArr = Stream.of(data.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private void numberArrValidation() {
        for (int inputNum : numberArr) {
            numberRangeValidation(inputNum);
        }
    }

    private void numberArrToNumbers() {
        numbers = Arrays
                .stream(numberArr)
                .boxed()
                .collect(Collectors.toList());
    }

    private void numbersValidation() {
        int checkDataSize = (int) numbers
                .stream()
                .distinct()
                .count();
        if (numbers.size() != checkDataSize) {
            throw new IllegalArgumentException();
        }
    }

    private void numberRangeValidation(int number) {
        if (!(1 <= number && number <= 9)) {
            throw new IllegalArgumentException();
        }
    }
}
