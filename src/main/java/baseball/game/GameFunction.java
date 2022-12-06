package baseball.game;

import java.util.List;

public class GameFunction {

    private static final String RETRY = "1";
    private static final String NO_RETRY = "2";
    private static final String RETRY_EXCEPTION_MSG = "1과 2의 값만 입력이 가능합니다.";

    public int ballCompare(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int result = 0;
        for (int number : playerNumbers) {
            if (computerNumbers.contains(number)) {
                result++;
            }
        }
        return result;
    }

    public int strikeCompare(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int result = 0;
        for (int i = 0; i < playerNumbers.size(); i++) {
            if (playerNumbers.get(i) == computerNumbers.get(i)) {
                result++;
            }
        }
        return result;
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
