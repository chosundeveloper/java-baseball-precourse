package baseball.pitching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("투구 숫자")
class PitchingNumberTest {

    @DisplayName("투구 숫자 생성")
    @ParameterizedTest
    @ValueSource(strings = {"1", "9"})
    void createPitchingNumber(int number) {
        assertDoesNotThrow(() -> new PitchingNumber(number));
    }

    @DisplayName("투구 숫자는 9보다 클 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"10", "11"})
    void maxPitchingNumber(int number) {
        assertThatThrownBy(() -> new PitchingNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("9보다 클 수 없습니다.");
    }

    @DisplayName("투구 숫자는 1보다 작을 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void minPitchingNumber(int number) {
        assertThatThrownBy(() -> new PitchingNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1보다 작을 수 없습니다.");
    }

}
