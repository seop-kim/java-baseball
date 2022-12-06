package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumbersGenerator {

    public List<Integer> createNumbers() {
        List<Integer> list = new ArrayList<>();
        while (list.size() != 3) {
            addNumberValidation(list, getRandomNumber());
        }
        return list;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    private void addNumberValidation(List<Integer> list, int number) {
        if (!list.contains(number)) {
            list.add(number);
        }
    }
}
