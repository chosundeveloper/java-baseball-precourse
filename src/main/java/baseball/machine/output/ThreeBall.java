package baseball.machine.output;

public class ThreeBall extends OutputMachine {
    public ThreeBall(int ballCount, int strikeCount) {
        super(ballCount, strikeCount);
    }

    @Override
    public void print() {
        System.out.println(getBallCount() + BALL);
    }

}
