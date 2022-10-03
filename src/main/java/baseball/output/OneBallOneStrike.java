package baseball.output;

public class OneBallOneStrike extends OutputMachine {

    public OneBallOneStrike(int ballCount, int strikeCount) {
        super(ballCount, strikeCount);
    }

    @Override
    public void print() {
        System.out.println(getBallCount() + BALL + " " + getStrikeCount() + STRIKE);
    }

}
