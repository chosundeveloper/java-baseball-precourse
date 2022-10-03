package baseball.output;

public abstract class OutputMachine {

    private final int ballCount;
    private final int strikeCount;

    protected static final String BALL = "볼";
    protected static final String STRIKE = "스트라이크";


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

    public static OutputMachine create(int ballCount, int strikeCount) {

        if (ballCount == 0 && strikeCount == 0) {
            return new Nothing(ballCount, strikeCount);
        }
        if (ballCount == 0 && strikeCount == 1) {
            return new OneStrike(ballCount, strikeCount);
        }
        if (ballCount == 0 && strikeCount == 2) {
            return new TwoStrike(ballCount, strikeCount);
        }
        if (ballCount == 0 && strikeCount == 3) {
            return new ThreeStrike(ballCount, strikeCount);
        }
        if (ballCount == 1 && strikeCount == 0) {
            return new OneBall(ballCount, strikeCount);
        }
        if (ballCount == 1 && strikeCount == 1) {
            return new OneBallOneStrike(ballCount, strikeCount);
        }
        if (ballCount == 1 && strikeCount == 2) {
            return new OneBallTwoStrike(ballCount, strikeCount);
        }
        if (ballCount == 2 && strikeCount == 0) {
            return new TwoBall(ballCount, strikeCount);
        }
        if (ballCount == 2 && strikeCount == 1) {
            return new TwoBallOneStrike(ballCount, strikeCount);
        }
        if (ballCount == 3 && strikeCount == 0) {
            return new ThreeBall(ballCount, strikeCount);
        }
        throw new IllegalArgumentException("해당하지 않습니다.");
    }

    public abstract void print();
}
