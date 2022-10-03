package baseball.machine.output;

public class TwoBallOneStrike extends OutputMachine {
    public TwoBallOneStrike(int ballCount, int strikeCount) {
        super(ballCount, strikeCount);
    }

    @Override
    public void print() {
        System.out.println(getBallCount() + BALL + " " + getStrikeCount() + STRIKE);
    }

}
