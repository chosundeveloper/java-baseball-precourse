package baseball.pitching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("투구")
class PitchingTest {

    @DisplayName("투구 생성")
    @Test
    void createPitching() {
        assertDoesNotThrow(() -> new Pitching(new PitchingNumber(1), new PitchingLocation(1)));
    }

}
