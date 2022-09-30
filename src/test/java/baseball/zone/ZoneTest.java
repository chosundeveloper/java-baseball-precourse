package baseball.zone;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("존")
class ZoneTest {

    @DisplayName("존 생성")
    @Test
    void createZone() {
        assertDoesNotThrow(() -> new Zone(new ZoneNumber(BigDecimal.ONE), new ZoneLocation(BigDecimal.ONE)));
    }

}
