package baseball.output;

public class OneBallTwoStrike extends OutputMachine {
    public OneBallTwoStrike(int ballCount, int strikeCount) {
        super(ballCount, strikeCount);
    }

    @Override
    public void print() {
        System.out.println(getBallCount() + BALL + " " + getStrikeCount() + STRIKE);
    }

}
