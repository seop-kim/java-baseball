package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerConvertor {
    private static final PlayerValidator VALIDATOR = new PlayerValidator();

    public List<Integer> createPlayerNumbers(String data) {
        VALIDATOR.inputValidation(data);

        int[] numberArr = dataToNumberArr(data);
        VALIDATOR.numberArrValidation(numberArr);

        List<Integer> numbers = numberArrToNumbers(numberArr);
        VALIDATOR.numbersValidation(numbers);

        return numbers;
    }

    private int[] dataToNumberArr(String data) {
        return Stream.of(data.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private List<Integer> numberArrToNumbers(int[] numberArr) {
        return Arrays
                .stream(numberArr)
                .boxed()
                .collect(Collectors.toList());
    }
}
