package baseball.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.GameFunction;
import baseball.exception.UserInputException;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameFunctionTest {
    GameFunction game = new GameFunction();

    @Nested
    class UserScore {
        @Test
        void userNumListAndComNumListCheckBallCount_1() {
            List<Integer> userList = List.of(1, 2, 3);
            List<Integer> comList = List.of(1, 2, 3);
            int result = 3;

            assertThat(game.ballCompare(userList, comList))
                    .isEqualTo(result);
        }

        @Test
        void userNumListAndComNumListCheckBallCount_2() {
            List<Integer> userList = List.of(1, 2, 3);
            List<Integer> comList = List.of(1, 2, 2);
            int result = 2;

            assertThat(game.ballCompare(userList, comList))
                    .isEqualTo(result);
        }

        @Test
        void userNumListAndComNumListCheckStrikeCount_1() {
            List<Integer> userList = List.of(1, 2, 3);
            List<Integer> comList = List.of(1, 2, 3);
            int result = 3;

            assertThat(game.strikeCompare(userList, comList))
                    .isEqualTo(result);
        }

        @Test
        void userNumListAndComNumListCheckStrikeCount_2() {
            List<Integer> userList = List.of(1, 2, 3);
            List<Integer> comList = List.of(1, 2, 2);
            int result = 2;

            assertThat(game.strikeCompare(userList, comList))
                    .isEqualTo(result);
        }
    }

    @Nested
    class ReStart {
        String inputChoice;

        @Test
        void reStart_ok() {
            inputChoice = "1";
            assertThat(game.retry(inputChoice))
                    .isTrue();
        }

        @Test
        void reStart_no() {
            inputChoice = "2";
            assertThat(game.retry(inputChoice))
                    .isFalse();
        }

        @Test
        void reStart_error_1() {
            inputChoice = "3";
            assertThatThrownBy(() -> game.retry(inputChoice))
                    .isInstanceOf(UserInputException.class);
        }

        @Test
        void reStart_error_2() {
            inputChoice = "A";
            assertThatThrownBy(() -> game.retry(inputChoice))
                    .isInstanceOf(UserInputException.class);
        }
    }
}