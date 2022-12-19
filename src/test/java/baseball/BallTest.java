package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Assertions.assertThat(result)
                .isTrue();
    }


}