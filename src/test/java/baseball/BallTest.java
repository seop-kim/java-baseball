package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {

    @DisplayName("스트라이크 체크")
    @Test
    void strike_check() {
        // given
        Ball ball = new Ball(1, 3);
        Ball otherBall = new Ball(1, 3);

        // when
        boolean result = ball.isStrike(otherBall);

        // then
        assertThat(result)
                .isTrue();
    }

    @DisplayName("볼 체크")
    @Test
    void ball_check() {
        // given
        Ball ball = new Ball(1, 3);
        Ball otherBall = new Ball(2, 3);

        // when
        boolean result = ball.isBall(otherBall);

        // then
        assertThat(result)
                .isTrue();
    }

    @DisplayName("낫싱 체크")
    @Test
    void nothing_check() {
        // given
        Ball ball = new Ball(1, 3);
        Ball otherBall = new Ball(2, 5);

        // when
        boolean result = ball.isNothing(otherBall);

        // then
        assertThat(result)
                .isTrue();
    }

    @DisplayName("볼의 크기가 1보다 작으면 에외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -3})
    void minimum_exception(int number) {
        assertThatThrownBy(() -> new Ball(1, number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("볼의 크기가 9보다 크면 에외 발생")
    @ParameterizedTest
    @ValueSource(ints = {10, 11, 1000, 50000})
    void maximum_exception(int number) {
        assertThatThrownBy(() -> new Ball(1, number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}