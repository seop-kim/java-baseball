package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RefereeTest {
    private static final List<Integer> ANSWER = Arrays.asList(1, 2, 3);
    Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
    }

    @DisplayName("3스트라이크")
    @Test
    public void strike3() throws Exception {
        // given
        List<Integer> computerNumbers = ANSWER;
        List<Integer> playerNumbers = ANSWER;
        String result = "0 볼 3 스트라이크";

        // when
        String test = referee.compare(computerNumbers, playerNumbers);

        // then
        Assertions.assertThat(test)
                .isEqualTo(result);
    }

    @DisplayName("아웃")
    @Test
    public void out() throws Exception {
        // given

        List<Integer> computerNumbers = Arrays.asList(4, 5, 7);
        List<Integer> playerNumbers = ANSWER;
        String result = "아웃";

        // when
        String test = referee.compare(computerNumbers, playerNumbers);

        // then
        Assertions.assertThat(test)
                .isEqualTo(result);
    }

    @DisplayName("3볼")
    @Test
    public void ball3() throws Exception {
        // given

        List<Integer> computerNumbers = Arrays.asList(3, 1, 2);
        List<Integer> playerNumbers = ANSWER;
        String result = "3 볼 0 스트라이크";

        // when
        String test = referee.compare(computerNumbers, playerNumbers);

        // then
        Assertions.assertThat(test)
                .isEqualTo(result);
    }

    @DisplayName("2볼 1스트라이크")
    @Test
    void ball2_strike1() {
        // given

        List<Integer> computerNumbers = Arrays.asList(2, 1, 3);
        List<Integer> playerNumbers = ANSWER;
        String result = "2 볼 1 스트라이크";

        // when
        String test = referee.compare(computerNumbers, playerNumbers);

        // then
        Assertions.assertThat(test)
                .isEqualTo(result);
    }

    @DisplayName("다수 테스트")
    @ParameterizedTest
    @CsvSource({"1,2,3,0 볼 3 스트라이크", "7,8,9,아웃", "2,3,1,3 볼 0 스트라이크", "1,3,2,2 볼 1 스트라이크"})
    void compareTest(int number1, int number2, int number3, String expected) {
        String actual = referee.compare(ANSWER, Arrays.asList(number1, number2, number3));
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }


}