package baseball.machine.output;

public class ThreeStrike extends OutputMachine {

    public ThreeStrike(int ballCount, int strikeCount) {
        super(ballCount, strikeCount);
    }

    @Override
    public void print() {
        System.out.println(getStrikeCount() + STRIKE);
    }

}
