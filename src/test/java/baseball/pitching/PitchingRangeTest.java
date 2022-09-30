package baseball.pitching;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("투구 영역")
class PitchingRangeTest {

    @DisplayName("투구 영역에 투구 숫자가 같을 경우 추가할 수 없다.")
    @Test
    void createPitchingRange() {
        PitchingRange pitchingRange = new PitchingRange();
        Pitching firstPitching = new Pitching(new PitchingNumber(BigDecimal.ONE), new PitchingLocation(BigDecimal.ONE));
        Pitching secondPitching = new Pitching(new PitchingNumber(BigDecimal.ONE), new PitchingLocation(BigDecimal.valueOf(2)));
        pitchingRange.add(firstPitching);
        assertThatThrownBy(() -> pitchingRange.add(secondPitching))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("투구 숫자가 중복입니다.");
    }

    @DisplayName("투구 영역에 투구 위치가 같을 경우 추가할 수 없다.")
    @Test
    void createPitchingLocation() {
        PitchingRange pitchingRange = new PitchingRange();
        Pitching firstPitching = new Pitching(new PitchingNumber(BigDecimal.ONE), new PitchingLocation(BigDecimal.ONE));
        Pitching secondPitching = new Pitching(new PitchingNumber(BigDecimal.valueOf(2)), new PitchingLocation(BigDecimal.ONE));
        pitchingRange.add(firstPitching);
        assertThatThrownBy(() -> pitchingRange.add(secondPitching))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("투구 위치가 중복입니다.");
    }

    @DisplayName("투구 영역에 4개 이상의 투구를 추가할 수 없다.")
    @Test
    void maxPitchingRange() {
        PitchingRange pitchingRange = new PitchingRange();
        Pitching firstPitching = new Pitching(new PitchingNumber(BigDecimal.ONE), new PitchingLocation(BigDecimal.ONE));
        Pitching secondPitching = new Pitching(new PitchingNumber(BigDecimal.valueOf(2)), new PitchingLocation(BigDecimal.valueOf(2)));
        Pitching thirdPitching = new Pitching(new PitchingNumber(BigDecimal.valueOf(3)), new PitchingLocation(BigDecimal.valueOf(3)));
        Pitching fourthPitching = new Pitching(new PitchingNumber(BigDecimal.valueOf(4)), new PitchingLocation(BigDecimal.valueOf(3)));
        pitchingRange.add(firstPitching);
        pitchingRange.add(secondPitching);
        pitchingRange.add(thirdPitching);
        assertThatThrownBy(() -> pitchingRange.add(fourthPitching))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("투구 영역에 4개 이상의 투구를 추가할 수 업습니다.");

    }

}
