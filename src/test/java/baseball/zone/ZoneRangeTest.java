package baseball.zone;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("존 영역")
class ZoneRangeTest {

    @DisplayName("존 영역에 존 숫자가 같을 경우 추가할 수 없다.")
    @Test
    void createZoneRange() {
        ZoneRange zoneRange = new ZoneRange();
        Zone firstZone = new Zone(new ZoneNumber(BigDecimal.ONE), new ZoneLocation(BigDecimal.ONE));
        Zone secondZone = new Zone(new ZoneNumber(BigDecimal.ONE), new ZoneLocation(BigDecimal.valueOf(2)));
        zoneRange.add(firstZone);
        assertThatThrownBy(() -> zoneRange.add(secondZone))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("존 숫자가 중복입니다.");
    }

    @DisplayName("존 영역에 존 위치가 같을 경우 추가할 수 없다.")
    @Test
    void createZoneLocation() {
        ZoneRange zoneRange = new ZoneRange();
        Zone firstZone = new Zone(new ZoneNumber(BigDecimal.ONE), new ZoneLocation(BigDecimal.ONE));
        Zone secondZone = new Zone(new ZoneNumber(BigDecimal.valueOf(2)), new ZoneLocation(BigDecimal.ONE));
        zoneRange.add(firstZone);
        assertThatThrownBy(() -> zoneRange.add(secondZone))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("존 위치가 중복입니다.");
    }

    @DisplayName("존 영역에 4개 이상의 존를 추가할 수 없다.")
    @Test
    void maxZoneRange() {
        ZoneRange zoneRange = new ZoneRange();
        Zone firstZone = new Zone(new ZoneNumber(BigDecimal.ONE), new ZoneLocation(BigDecimal.ONE));
        Zone secondZone = new Zone(new ZoneNumber(BigDecimal.valueOf(2)), new ZoneLocation(BigDecimal.valueOf(2)));
        Zone thirdZone = new Zone(new ZoneNumber(BigDecimal.valueOf(3)), new ZoneLocation(BigDecimal.valueOf(3)));
        Zone fourthZone = new Zone(new ZoneNumber(BigDecimal.valueOf(4)), new ZoneLocation(BigDecimal.valueOf(3)));
        zoneRange.add(firstZone);
        zoneRange.add(secondZone);
        zoneRange.add(thirdZone);
        assertThatThrownBy(() -> zoneRange.add(fourthZone))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("존 영역에 4개 이상의 존를 추가할 수 업습니다.");
    }

}
