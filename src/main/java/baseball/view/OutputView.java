package baseball.view;

public class OutputView {
    private static final String START_MSG = "숫자 야구 게임을 시작합니다.";
    private static final String REQUEST_INPUT_MSH = "숫자를 입력해주세요 : ";
    private static final String SCORE_NO_MATCH = "낫싱";
    private static final String SCORE_ALL_MATCH = "%d볼 %d스트라이크\n";
    private static final String SCORE_BALL_MATCH = "%d볼\n";
    private static final String SCORE_STRIKE_MATCH = "%d스트라이크\n";
    private static final String GAME_FINISH_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String REQUEST_RETRY_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printScore(int strikeScore, int ballScore) {
        finishGame(strikeScore, ballScore);
        zeroScore(strikeScore, ballScore);
        oneScoreMatch(strikeScore, ballScore);
        allScore(strikeScore, ballScore);
    }

    public void printGameStart() {
        System.out.println(START_MSG);
    }

    public void printInputRequest() {
        System.out.print(REQUEST_INPUT_MSH);
    }

    private void zeroScore(int strikeScore, int ballScore) {
        if (strikeScore == 0 && ballScore == 0) {
            System.out.println(SCORE_NO_MATCH);
        }
    }

    private void allScore(int strikeScore, int ballScore) {
        if (strikeScore != 0 && ballScore != 0 && strikeScore <= 3 && ballScore <= 3) {
            System.out.printf(SCORE_ALL_MATCH, ballScore, strikeScore);
        }
    }

    private void finishGame(int strikeScore, int ballScore) {
        if (strikeScore == 3 && ballScore == 0) {
            System.out.printf(SCORE_STRIKE_MATCH, strikeScore);
            System.out.println(GAME_FINISH_MSG);
            System.out.println(REQUEST_RETRY_MSG);
        }
    }

    private void oneScoreMatch(int strikeScore, int ballScore) {
        if (strikeScore == 0 && ballScore <= 3) {
            System.out.printf(SCORE_BALL_MATCH, ballScore);
        }

        if (ballScore == 0 && strikeScore <= 3) {
            System.out.printf(SCORE_STRIKE_MATCH, strikeScore);
        }
    }

}
