package baseball.machine.output;

public class OneStrike extends OutputMachine {
    public OneStrike(int ballCount, int strikeCount) {
        super(ballCount, strikeCount);
    }

    @Override
    public void print() {
        System.out.println(getStrikeCount() + STRIKE);
    }

}
