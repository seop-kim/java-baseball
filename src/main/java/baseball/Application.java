package baseball;

import baseball.domain.Judgment;
import baseball.domain.NumberGenerator;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
//        NumberGenerator generator = new NumberGenerator();
//        List<Integer> computers = generator.createRandomNumbers();
//        System.out.println("computers = " + computers);

        Judgment judgment = new Judgment();
//        int count = judgment.correctCount(
//                Arrays.asList(1, 2, 3),
//                Arrays.asList(1, 2, 3)
//        );
//        System.out.println("count = " + count);

        boolean check = judgment.hasPlace(Arrays.asList(7, 8, 9), 0, 7);
        System.out.println("check = " + check);
    }
}
