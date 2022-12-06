package baseball.view;

public class OutputView {
    public void printGameStartMsg() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputRequestMsg() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printScoreMsg(int strikeScore, int ballScore) {
        if (strikeScore == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return;
        }

        if (strikeScore == 0 && ballScore == 0) {
            System.out.println("낫싱");
            return;
        }

        if (strikeScore == 0 && ballScore <= 3) {
            System.out.println(ballScore + "볼");
            return;
        }

        if (ballScore == 0 && strikeScore <= 3) {
            System.out.println(strikeScore + "스트라이크");
            return;
        }

        System.out.println(ballScore + "볼 " + strikeScore + "스트라이크");
    }
}
