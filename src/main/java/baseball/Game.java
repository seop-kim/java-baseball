package baseball;

import baseball.domain.Comparator;
import baseball.domain.NumbersGenerator;
import baseball.domain.PlayerConvertor;
import baseball.domain.PlayerValidator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class Game {
    private static final PlayerConvertor PLAYER = new PlayerConvertor();
    private static final NumbersGenerator COMPUTER = new NumbersGenerator();
    private static final PlayerValidator VALIDATOR = new PlayerValidator();
    private static final Comparator COMPARATOR = new Comparator();
    private static final InputView INPUT_VIEW = new InputView();
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private static List<Integer> COMPUTER_NUMBERS;
    private static List<Integer> PLAYER_NUMBERS;
    private int ballScore = 0;
    private int strikeScore = 0;
    private boolean playingGames = false;
    private boolean gameAgain = true;

    public void go() {
        while (gameAgain) {
            isPlayingGames();
            PLAYER_NUMBERS = requestPlayerNumbers();
            calScore();
            OUTPUT_VIEW.printScore(strikeScore, ballScore);
            isGameEnd();
        }
    }

    private void calScore() {
        strikeScore = COMPARATOR.strikeCompare(PLAYER_NUMBERS, COMPUTER_NUMBERS);
        ballScore = COMPARATOR.ballCompare(PLAYER_NUMBERS, COMPUTER_NUMBERS) - strikeScore;
    }

    private void isPlayingGames() {
        if (!playingGames) {
            COMPUTER_NUMBERS = COMPUTER.createNumbers();
            playingGames = true;
        }
    }

    private void isGameEnd() {
        if (strikeScore == 3) {
            gameAgain = retry(INPUT_VIEW.requestPlayerInput());
            playingGames = false;
        }
    }

    private List<Integer> requestPlayerNumbers() {
        OUTPUT_VIEW.printInputRequest();
        return PLAYER.createPlayerNumbers(INPUT_VIEW.requestPlayerInput());
    }

    private boolean retry(String input) {
        VALIDATOR.retryValidation(input); // Validator 에서 1 과 2의 검증은 끝난다.
        return input.equals(Message.RETRY.text());
    }
}
