package baseball.pitching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PitchingRange {

    private final List<Pitching> pitchings = new ArrayList<>();

    public void add(Pitching pitching) {
        validMaxPitchingCount();
        validateDuplicatePitchingNumber(pitching.pitchingNumber());
        validateDuplicatePitchingLocation(pitching.pitchingLocation());
        this.pitchings.add(pitching);
    }

    private void validMaxPitchingCount() {
        if (this.pitchings.size() >= 3) {
            throw new IllegalArgumentException("투구 영역에 4개 이상의 투구를 추가할 수 업습니다.");
        }
    }

    public List<PitchingNumber> pitchingNumbers() {
        List<PitchingNumber> pitchingNumbers = new ArrayList<>();
        for (Pitching pitching : this.pitchings) {
            pitchingNumbers.add(pitching.pitchingNumber());
        }
        return Collections.unmodifiableList(pitchingNumbers);
    }

    public List<PitchingLocation> pitchingLocations() {
        List<PitchingLocation> pitchingLocations = new ArrayList<>();
        for (Pitching pitching : this.pitchings) {
            pitchingLocations.add(pitching.pitchingLocation());
        }
        return Collections.unmodifiableList(pitchingLocations);
    }

    private void validateDuplicatePitchingNumber(PitchingNumber addPitchingNumber) {
        if (pitchingNumbers().contains(addPitchingNumber)) {
            throw new IllegalArgumentException("투구 숫자가 중복입니다.");
        }
    }

    private void validateDuplicatePitchingLocation(PitchingLocation addPitchingLocation) {
        if (pitchingLocations().contains(addPitchingLocation)) {
            throw new IllegalArgumentException("투구 위치가 중복입니다.");
        }
    }
}
