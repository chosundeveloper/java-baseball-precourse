package baseball.zone;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("존 위치")
class ZoneLocationTest {

    @DisplayName("존 위치 생성")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void createZoneLocation(BigDecimal location) {
        assertDoesNotThrow(() -> new ZoneLocation(location));
    }

    @DisplayName("존 위치는 3보다 클 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"4", "5"})
    void maxZoneLocation(BigDecimal location) {
        assertThatThrownBy(() -> new ZoneLocation(location))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3보다 클 수 없습니다.");
    }

    @DisplayName("존 위치는 1보다 작을 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void minZoneLocation(BigDecimal location) {
        assertThatThrownBy(() -> new ZoneLocation(location))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1보다 작을 수 없습니다.");
    }

}
