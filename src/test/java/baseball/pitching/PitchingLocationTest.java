package baseball.pitching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("투구 위치")
class PitchingLocationTest {

    @DisplayName("투구 위치 생성")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void createPitchingLocation(BigDecimal location) {
        assertDoesNotThrow(() -> new PitchingLocation(location));
    }

    @DisplayName("투구 위치는 3보다 클 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"4", "5"})
    void maxPitchingLocation(BigDecimal location) {
        assertThatThrownBy(() -> new PitchingLocation(location))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3보다 클 수 없습니다.");
    }

    @DisplayName("투구 위치는 1보다 작을 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void minPitchingLocation(BigDecimal location) {
        assertThatThrownBy(() -> new PitchingLocation(location))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1보다 작을 수 없습니다.");
    }

}
