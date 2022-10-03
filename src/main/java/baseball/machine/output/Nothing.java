package baseball.machine.output;

public class Nothing extends OutputMachine {

    private static final String NOTHING = "낫싱";

    public Nothing(int ballCount, int strikeCount) {
        super(ballCount, strikeCount);
    }

    @Override
    public void print() {
        System.out.println(NOTHING);
    }

}
