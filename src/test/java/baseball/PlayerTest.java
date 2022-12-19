package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("입력 값이 3개가 아니면 예외 발생")
    @Test
    void input_size_exception() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4);
        String resultMsg = "입력 값은 3개의 숫자여야 합니다.";

        // when && then
        assertThatThrownBy(() -> new Player(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(resultMsg);
    }


}