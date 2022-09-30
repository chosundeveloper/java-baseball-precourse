package baseball.zone;

import java.math.BigDecimal;
import java.util.Objects;

public class ZoneNumber {

    public static final BigDecimal MAX_PITCHING_NUMBER = BigDecimal.valueOf(9);
    public static final BigDecimal MIN_PITCHING_NUMBER = BigDecimal.valueOf(1);
    private final BigDecimal number;

    public ZoneNumber(BigDecimal number) {
        validate(number);
        this.number = number;
    }

    private void validate(BigDecimal number) {
        validateMaxPitchingNumber(number);
        validateMinPitchingNumber(number);
    }

    private static void validateMaxPitchingNumber(BigDecimal number) {
        if (number.compareTo(MAX_PITCHING_NUMBER) > 0) {
            throw new IllegalArgumentException("9보다 클 수 없습니다.");
        }
    }

    private void validateMinPitchingNumber(BigDecimal number) {
        if (number.compareTo(MIN_PITCHING_NUMBER) < 0) {
            throw new IllegalArgumentException("1보다 작을 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZoneNumber that = (ZoneNumber) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
