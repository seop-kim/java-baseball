package baseball.domain;

import java.util.List;

public class Comparator {

    private static final String RETRY = "1";
    private static final String NO_RETRY = "2";
    private static final String RETRY_EXCEPTION_MSG = "1과 2의 값만 입력이 가능합니다.";

    public int ballCompare(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int result = 0;
        for (int number : playerNumbers) {
            result += calBallScore(computerNumbers.contains(number));
        }
        return result;
    }

    public int strikeCompare(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int result = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            result += calStrikeScore(playerNumbers.get(i), computerNumbers.get(i));
        }
        return result;
    }

    private int calBallScore(boolean check) {
        if (check) {
            return 1;
        }
        return 0;
    }

    private int calStrikeScore(int playerNumber, int computerNumber) {
        if (playerNumber == computerNumber) {
            return 1;
        }
        return 0;
    }

    public boolean retry(String input) {
        if (input.equals(RETRY)) {
            return true;
        }
        if (input.equals(NO_RETRY)) {
            return false;
        }
        throw new IllegalArgumentException(RETRY_EXCEPTION_MSG);
    }
}
