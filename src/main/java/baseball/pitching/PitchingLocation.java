package baseball.pitching;

import java.math.BigDecimal;
import java.util.Objects;

public class PitchingLocation {

    public static final BigDecimal MAX_PITCHING_LOCATION = BigDecimal.valueOf(3);
    public static final BigDecimal MIN_PITCHING_LOCATION = BigDecimal.valueOf(1);
    private final BigDecimal location;

    public PitchingLocation(BigDecimal location) {
        validate(location);
        this.location = location;
    }

    private void validate(BigDecimal location) {
        validateMaxPitchingLocation(location);
        validateMinPitchingLocation(location);
    }

    private static void validateMaxPitchingLocation(BigDecimal location) {
        if (location.compareTo(MAX_PITCHING_LOCATION) > 0) {
            throw new IllegalArgumentException("3보다 클 수 없습니다.");
        }
    }

    private void validateMinPitchingLocation(BigDecimal location) {
        if (location.compareTo(MIN_PITCHING_LOCATION) < 0) {
            throw new IllegalArgumentException("1보다 작을 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PitchingLocation that = (PitchingLocation) o;
        return location.equals(that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

}
