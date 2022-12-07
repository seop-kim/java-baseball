package baseball.view;

import baseball.Message;

public class OutputView {
    private static int STRIKE_SCORE;
    private static int BALL_SCORE;

    public OutputView() {
        System.out.println(Message.START_MSG.text());
    }

    public void printScore(int strikeScore, int ballScore) {
        STRIKE_SCORE = strikeScore;
        BALL_SCORE = ballScore;
        finishGame();
        zeroScore();
        oneScoreMatch();
        allScore();
    }

    public void printInputRequest() {
        System.out.print(Message.REQUEST_INPUT_MSG.text());
    }

    private void zeroScore() {
        if (STRIKE_SCORE == 0 && BALL_SCORE == 0) {
            System.out.println(Message.SCORE_NO_MATCH.text());
        }
    }

    private void allScore() {
        if (STRIKE_SCORE != 0 && BALL_SCORE != 0 && STRIKE_SCORE <= 3 && BALL_SCORE <= 3) {
            System.out.printf(Message.SCORE_ALL_MATCH.text(), BALL_SCORE, STRIKE_SCORE);
        }
    }

    private void finishGame() {
        if (STRIKE_SCORE == 3 && BALL_SCORE == 0) {
            System.out.printf(Message.SCORE_STRIKE_MATCH.text(), STRIKE_SCORE);
            System.out.println(Message.GAME_FINISH_MSG.text());
            System.out.println(Message.REQUEST_RETRY_MSG.text());
        }
    }

    private void oneScoreMatch() {
        if (STRIKE_SCORE == 0 && BALL_SCORE != 0 && BALL_SCORE <= 3) {
            System.out.printf(Message.SCORE_BALL_MATCH.text(), BALL_SCORE);
        }

        if (BALL_SCORE == 0 && STRIKE_SCORE != 0 && STRIKE_SCORE < 3) {
            System.out.printf(Message.SCORE_STRIKE_MATCH.text(), STRIKE_SCORE);
        }
    }

}
