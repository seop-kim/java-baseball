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
    private static final PlayerValidator VALIDATOR = new PlayerValidator();
    private static final NumbersGenerator COMPUTER = new NumbersGenerator();
    private static final Comparator COM = new Comparator();
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private static List<Integer> computerNumList;
    private static List<Integer> playerNumbers;
    private static final InputView INPUT_VIEW = new InputView();

    private static final String RETRY = "1";
    boolean playingGames = false;
    int ballScore = 0;
    int strikeScore = 0;
    String userInput;
    boolean gameAgain = true;

    public void go() {
        OUTPUT_VIEW.printGameStartMsg();
        while (gameAgain) {
            isPlayingGames();
            playerNumbers = getPlayerNumbers();
            calScore();
            OUTPUT_VIEW.printScoreMsg(strikeScore, ballScore);
            isGameEnd();
        }
    }

    private void calScore() {
        strikeScore = COM.strikeCompare(playerNumbers, computerNumList);
        ballScore = COM.ballCompare(playerNumbers, computerNumList) - strikeScore;
    }

    private void isPlayingGames() {
        if (!playingGames) {
            computerNumList = COMPUTER.createNumbers();
            playingGames = true;
        }
    }

    private void isGameEnd() {
        if (strikeScore == 3) {
            userInput = INPUT_VIEW.requestPlayerInput();
            gameAgain = retry(userInput);
            playingGames = false;
        }
    }

    private List<Integer> getPlayerNumbers() {
        OUTPUT_VIEW.printInputRequestMsg();
        return PLAYER.createPlayerNumbers(INPUT_VIEW.requestPlayerInput());
    }

    private boolean retry(String input) {
        VALIDATOR.retryValidation(input); // Validator 에서 이미 1 과 2의 검증은 끝난다.
        return input.equals(RETRY);
    }
}
