package baseball.view;

import baseball.Message;

public class OutputView {
    private static int STRIKE_SCORE;
    private static int BALL_SCORE;

    public OutputView() {
        System.out.println(Message.text(Message.START_MSG));
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
        System.out.print(Message.text(Message.REQUEST_INPUT_MSG));
    }

    private void zeroScore() {
        if (STRIKE_SCORE == 0 && BALL_SCORE == 0) {
            System.out.println(Message.text(Message.SCORE_NO_MATCH));
        }
    }

    private void allScore() {
        if (STRIKE_SCORE != 0 && BALL_SCORE != 0 && STRIKE_SCORE <= 3 && BALL_SCORE <= 3) {
            System.out.printf(Message.text(Message.SCORE_ALL_MATCH), BALL_SCORE, STRIKE_SCORE);
        }
    }

    private void finishGame() {
        if (STRIKE_SCORE == 3 && BALL_SCORE == 0) {
            System.out.printf(Message.text(Message.SCORE_STRIKE_MATCH), STRIKE_SCORE);
            System.out.println(Message.text(Message.GAME_FINISH_MSG));
            System.out.println(Message.text(Message.REQUEST_RETRY_MSG));
        }
    }

    private void oneScoreMatch() {
        if (STRIKE_SCORE == 0 && BALL_SCORE != 0 && BALL_SCORE <= 3) {
            System.out.printf(Message.text(Message.SCORE_BALL_MATCH), BALL_SCORE);
        }

        if (BALL_SCORE == 0 && STRIKE_SCORE != 0 && STRIKE_SCORE < 3) {
            System.out.printf(Message.text(Message.SCORE_STRIKE_MATCH), STRIKE_SCORE);
        }
    }

}
