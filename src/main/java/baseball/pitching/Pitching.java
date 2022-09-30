package baseball.pitching;

public class Pitching {

    private final PitchingNumber pitchingNumber;
    private final PitchingLocation pitchingLocation;

    public Pitching(PitchingNumber pitchingNumber, PitchingLocation pitchingLocation) {
        this.pitchingNumber = pitchingNumber;
        this.pitchingLocation = pitchingLocation;
    }

    public PitchingNumber pitchingNumber() {
        return this.pitchingNumber;
    }

    public PitchingLocation pitchingLocation() {
        return this.pitchingLocation;
    }

}
