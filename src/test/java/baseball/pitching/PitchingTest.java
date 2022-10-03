package baseball.pitching;

import baseball.ball.domain.Ball;
import baseball.ball.domain.BallLocation;
import baseball.ball.domain.BallNumber;
import baseball.pitching.domain.Pitching;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("투구")
class PitchingTest {

    @DisplayName("투구를 생성한다.")
    @Test
    void createPitching() {
        Pitching pitching = new Pitching();
        Ball firstBall = new Ball(new BallNumber(BigDecimal.ONE), new BallLocation(BigDecimal.ONE));
        Ball secondBall = new Ball(new BallNumber(BigDecimal.valueOf(2)), new BallLocation(BigDecimal.valueOf(2)));
        Ball thirdBall = new Ball(new BallNumber(BigDecimal.valueOf(3)), new BallLocation(BigDecimal.valueOf(3)));
        pitching.add(firstBall);
        pitching.add(secondBall);
        pitching.add(thirdBall);
        assertThat(pitching.pitchingBalls().size()).isEqualTo(3);
    }

    @DisplayName("투구 숫자가 같을 경우 추가할 수 없다.")
    @Test
    void createDuplicateBallNumber() {
        Pitching pitching = new Pitching();
        Ball firstBall = new Ball(new BallNumber(BigDecimal.ONE), new BallLocation(BigDecimal.ONE));
        Ball secondBall = new Ball(new BallNumber(BigDecimal.ONE), new BallLocation(BigDecimal.valueOf(2)));
        pitching.add(firstBall);
        assertThatThrownBy(() -> pitching.add(secondBall))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("투구 숫자가 중복입니다.");
    }

    @DisplayName("투구 위치가 같을 경우 추가할 수 없다.")
    @Test
    void createDuplicateBallLocation() {
        Pitching pitching = new Pitching();
        Ball firstBall = new Ball(new BallNumber(BigDecimal.ONE), new BallLocation(BigDecimal.ONE));
        Ball secondBall = new Ball(new BallNumber(BigDecimal.valueOf(2)), new BallLocation(BigDecimal.ONE));
        pitching.add(firstBall);
        assertThatThrownBy(() -> pitching.add(secondBall))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("투구 위치가 중복입니다.");
    }

    @DisplayName("4개 이상의 투구를 추가할 수 없다.")
    @Test
    void maxBallSize() {
        Pitching pitching = new Pitching();
        Ball firstBall = new Ball(new BallNumber(BigDecimal.ONE), new BallLocation(BigDecimal.ONE));
        Ball secondBall = new Ball(new BallNumber(BigDecimal.valueOf(2)), new BallLocation(BigDecimal.valueOf(2)));
        Ball thirdBall = new Ball(new BallNumber(BigDecimal.valueOf(3)), new BallLocation(BigDecimal.valueOf(3)));
        Ball fourthBall = new Ball(new BallNumber(BigDecimal.valueOf(4)), new BallLocation(BigDecimal.valueOf(3)));
        pitching.add(firstBall);
        pitching.add(secondBall);
        pitching.add(thirdBall);
        assertThatThrownBy(() -> pitching.add(fourthBall))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("투구 영역에 4개 이상의 투구를 추가할 수 업습니다.");
    }

}
