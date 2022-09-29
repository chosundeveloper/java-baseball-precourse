package baseball.pitching;

public class PitchingNumber {

    public static final int MAX_PITCHING_NUMBER = 9;
    public static final int MIN_PITCHING_NUMBER = 1;
    private final int number;

    public PitchingNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        validateMaxPitchingNumber(number);
        validateMinPitchingNumber(number);
    }

    private static void validateMaxPitchingNumber(int number) {
        if (MAX_PITCHING_NUMBER < number) {
            throw new IllegalArgumentException("9보다 클 수 없습니다.");
        }
    }

    private void validateMinPitchingNumber(int number) {
        if (number < MIN_PITCHING_NUMBER) {
            throw new IllegalArgumentException("1보다 작을 수 없습니다.");
        }
    }

    public int getNumber() {
        return number;
    }
}
