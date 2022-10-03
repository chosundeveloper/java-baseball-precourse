package baseball.ball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("볼")
class BallTest {

    @DisplayName("볼 생성")
    @Test
    void createBall() {
        assertDoesNotThrow(() -> new Ball(new BallNumber(BigDecimal.ONE), new BallLocation(BigDecimal.ONE)));
    }

}