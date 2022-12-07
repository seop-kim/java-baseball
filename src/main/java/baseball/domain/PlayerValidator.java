package baseball.domain;

import baseball.Message;
import java.util.List;

public class PlayerValidator {
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
        if (!(input.equals(Message.RETRY.text()) || input.equals(Message.NO_RETRY.text()))) {
            throw new IllegalArgumentException();
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
