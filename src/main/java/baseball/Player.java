package baseball;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Player {
    private static final int CRITERION_NUMBER_SIZE = 3;
    private static final String NUMBER_SIZE_EXCEPTION_MSG = "입력 값은 3개의 숫자여야 합니다.";
    private static final String NUMBER_SAME_EXCEPTION_MSG = "입력 값은 서로 다른 수 3개로 구성되어 있어야 합니다.";
    private static final int NUMBER_INDEX_ZERO = 0;
    private static final int NUMBER_INDEX_ONE = 1;
    private static final int NUMBER_INDEX_TWO = 2;

    private final List<Ball> balls;

    public Player(List<Integer> numbers) {
        validateSize(numbers);
        validateSameNumbers(numbers);
        this.balls = convertBall(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != CRITERION_NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_EXCEPTION_MSG);
        }
    }

    private void validateSameNumbers(List<Integer> numbers) {
        if (isSameNumber(numbers.get(NUMBER_INDEX_ZERO), numbers.get(NUMBER_INDEX_ONE))) {
            throw new IllegalArgumentException(NUMBER_SAME_EXCEPTION_MSG);
        }
        if (isSameNumber(numbers.get(NUMBER_INDEX_ZERO), numbers.get(NUMBER_INDEX_TWO))) {
            throw new IllegalArgumentException(NUMBER_SAME_EXCEPTION_MSG);
        }
        if (isSameNumber(numbers.get(NUMBER_INDEX_ONE), numbers.get(NUMBER_INDEX_TWO))) {
            throw new IllegalArgumentException(NUMBER_SAME_EXCEPTION_MSG);
        }
    }

    private boolean isSameNumber(Integer number, Integer otherNumber) {
        return number.equals(otherNumber);
    }

    private List<Ball> convertBall(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> new Ball(new AtomicInteger().getAndIncrement(), number))
                .collect(Collectors.toList());
    }


    public GameResult playGame(Player otherPlayer) {
        GameResult gameResult = new GameResult();

        for (Ball ball : balls) {
            BallStatus ballStatus = otherPlayer.play(ball);
            gameResult.addResult(ballStatus);
        }
        return gameResult;
    }

    private BallStatus play(Ball otherBall) {
        return this.balls.stream()
                .map(ball -> ball.play(otherBall))
                .filter(ballStatus -> !ballStatus.isNothing())
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }
}
