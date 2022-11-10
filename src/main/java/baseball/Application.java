package baseball;

import baseball.domain.Judgment;
import baseball.domain.NumberGenerator;
import baseball.domain.Referee;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final Referee referee = new Referee();
        final String compare = referee.compare(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 3)
        );
        System.out.println(compare);

    }
}
