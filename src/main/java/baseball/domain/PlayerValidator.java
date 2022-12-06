package baseball.domain;

import java.util.List;

public class PlayerValidator {
    private static final String RETRY = "1";
    private static final String NO_RETRY = "2";
    private static final String RETRY_EXCEPTION_MSG = "1과 2의 값만 입력이 가능합니다.";

    public void inputValidation(String data) {
        inputLengthValidation(data);
        inputNumberValidation(data);
    }

    public void numberArrValidation(int[] numberArr) {
        for (int inputNum : numberArr) {
            numberRangeValidation(inputNum);
        }
    }

    public void numbersValidation(List<Integer> numbers) {
        int checkDataSize = (int) numbers
                .stream()
                .distinct()
                .count();
        if (numbers.size() != checkDataSize) {
            throw new IllegalArgumentException();
        }
    }

    public void retryValidation(String input) {
        if (!(input.equals(RETRY) || input.equals(NO_RETRY))) {
            throw new IllegalArgumentException(RETRY_EXCEPTION_MSG);
        }
    }

    private void inputLengthValidation(String data) {
        if (data.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private void inputNumberValidation(String data) {
        try {
            Integer.parseInt(data);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    private void numberRangeValidation(int number) {
        if (!(1 <= number && number <= 9)) {
            throw new IllegalArgumentException();
        }
    }
}
