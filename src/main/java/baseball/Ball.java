package baseball;

public class Ball {

    private static final int MINIMUM_BALL_NUMBER = 1;
    private static final int MAXIMUM_BALL_NUMBER = 9;
    private static final String BALL_NUMBER_EXCEPTION_MSG = "볼은 1~9만 입력이 가능합니다.";
    private final int position;
    private final int number;

    public Ball(int position, int number) {
        validate(number);
        this.position = position;
        this.number = number;
    }

    private void validate(int number) {
        if (number < MINIMUM_BALL_NUMBER || MAXIMUM_BALL_NUMBER < number) {
            throw new IllegalArgumentException(BALL_NUMBER_EXCEPTION_MSG);
        }
    }

    public boolean isStrike(Ball otherBall) {
        return isSameIndex(otherBall) && isSameNumber(otherBall);
    }

    public boolean isBall(Ball otherBall) {
        return isSameIndex(otherBall) && isSameNumber(otherBall);
    }

    public boolean isNothing(Ball otherBall) {
        return !isSameIndex(otherBall) && !isSameNumber(otherBall);
    }

    private boolean isSameIndex(Ball otherBall) {
        return this.position == otherBall.position;
    }

    private boolean isSameNumber(Ball otherBall) {
        return this.number == otherBall.number;
    }
}
