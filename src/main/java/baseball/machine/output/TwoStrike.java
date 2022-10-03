package baseball.machine.output;

public class TwoStrike extends OutputMachine {
    public TwoStrike(int ballCount, int strikeCount) {
        super(ballCount, strikeCount);
    }

    @Override
    public void print() {
        System.out.println(getStrikeCount() + STRIKE);
    }

}
