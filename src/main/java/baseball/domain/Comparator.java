package baseball.domain;

import java.util.List;

public class Comparator {

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
}
