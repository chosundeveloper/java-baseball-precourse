package baseball.ball;

public class Ball {

    private final BallNumber ballNumber;
    private final BallLocation ballLocation;

    public Ball(BallNumber ballNumber, BallLocation ballLocation) {
        this.ballNumber = ballNumber;
        this.ballLocation = ballLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball that = (Ball) o;
        return ballLocation.equals(that.ballLocation) && ballNumber.equals(that.ballNumber);
    }

}
