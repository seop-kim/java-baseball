package baseball;

public enum Message {
    START_MSG("숫자 야구 게임을 시작합니다."),
    REQUEST_INPUT_MSG("숫자를 입력해주세요 : "),
    SCORE_NO_MATCH("낫싱"),
    SCORE_ALL_MATCH("%d볼 %d스트라이크\n"),
    SCORE_BALL_MATCH("%d볼\n"),
    SCORE_STRIKE_MATCH("%d스트라이크\n"),
    GAME_FINISH_MSG("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    REQUEST_RETRY_MSG("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    RETRY("1"),
    NO_RETRY("2");


    private String text;

    Message(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }
}
