package baseball.output;

public class OneBall extends OutputMachine {
    public OneBall(int ballCount, int strikeCount) {
        super(ballCount, strikeCount);
    }

    @Override
    public void print() {
        System.out.println(getBallCount() + BALL);
    }

}
