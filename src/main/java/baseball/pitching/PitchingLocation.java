package baseball.pitching;

public class PitchingLocation {

    public static final int MAX_PITCHING_LOCATION = 3;
    public static final int MIN_PITCHING_LOCATION = 1;
    private final int location;

    public PitchingLocation(int location) {
        validate(location);
        this.location = location;
    }

    private void validate(int location) {
        validateMaxPitchingLocation(location);
        validateMinPitchingLocation(location);
    }

    private static void validateMaxPitchingLocation(int location) {
        if (location > MAX_PITCHING_LOCATION) {
            throw new IllegalArgumentException("3보다 클 수 없습니다.");
        }
    }

    private void validateMinPitchingLocation(int location) {
        if (location < MIN_PITCHING_LOCATION) {
            throw new IllegalArgumentException("1보다 작을 수 없습니다.");
        }
    }

    public int getLocation() {
        return location;
    }
}
