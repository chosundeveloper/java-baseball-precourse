package baseball.output;

public class TwoBall extends OutputMachine {
    public TwoBall(int ballCount, int strikeCount) {
        super(ballCount, strikeCount);
    }

    @Override
    public void print() {
        System.out.println(getBallCount() + BALL);
    }
}
