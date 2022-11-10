package baseball.domain;

import java.util.List;

public class Referee {
    public String compare(List<Integer> computer, List<Integer> player) {
        // 몇 개의 숫자가 같은지 알아낸 뒤
        // 스트라이크의 개수를 구해 뺀다. == 볼의 개수
        final Judgment judgment = new Judgment();
        int correctCount = judgment.correctCount(computer, player);
        int strike = 0;
        for (int placeIndex = 0; placeIndex < computer.size(); placeIndex++) {
            if (judgment.hasPlace(computer, placeIndex, player.get(placeIndex))) {
                strike++;
            }
        }

        int ball = correctCount - strike;
        if (correctCount == 0) {
            return "아웃";
        }
        return ball + " 볼 " + strike + " 스트라이크";
    }
}
