package baseball;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Player {
    private static final int CRITERION_NUMBER_SIZE = 3;
    private static final String NUMBER_SIZE_EXCEPTION_MSG = "입력 값은 3개의 숫자여야 합니다.";

    private final List<Ball> balls;

    public Player(List<Integer> numbers) {
        validate(numbers);
        this.balls = convertBall(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != CRITERION_NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_EXCEPTION_MSG);
        }
    }

    private List<Ball> convertBall(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> new Ball(new AtomicInteger().getAndIncrement(), number))
                .collect(Collectors.toList());
    }
}
