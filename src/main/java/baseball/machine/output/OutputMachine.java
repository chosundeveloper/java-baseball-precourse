package baseball.machine.output;

public class OutputMachine {

    private final int ballCount;
    private final int strikeCount;

    protected static final String BALL = "볼";
    protected static final String STRIKE = "스트라이크";
    protected static final String NOTHING = "낫싱";



    public OutputMachine(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void print() {
        String message = makeMessage();
        System.out.println(message);
    }

    private String makeMessage() {
        int strikeCount = getStrikeCount();
        int ballCount = getBallCount();

        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING;
        }

        return ballMessage(ballCount) + strikeMessage(strikeCount);
    }

    private String ballMessage(int ballCount) {
        if (ballCount == 0) {
            return "";
        }
        return ballCount + BALL + " ";
    }

    private String strikeMessage(int strikeCount) {
        if (strikeCount == 0) {
            return "";
        }
        return strikeCount + STRIKE;
    }

}



