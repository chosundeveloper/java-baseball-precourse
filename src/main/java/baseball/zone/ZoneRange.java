package baseball.zone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZoneRange {

    private final List<Zone> zones = new ArrayList<>();

    public void add(Zone zone) {
        validMaxZoneCount();
        validateDuplicateZoneNumber(zone.zoneNumber());
        validateDuplicateZoneLocation(zone.zoneLocation());
        this.zones.add(zone);
    }

    private void validMaxZoneCount() {
        if (this.zones.size() >= 3) {
            throw new IllegalArgumentException("존 영역에 4개 이상의 존를 추가할 수 업습니다.");
        }
    }

    public List<ZoneNumber> zoneNumbers() {
        List<ZoneNumber> zoneNumbers = new ArrayList<>();
        for (Zone zone : this.zones) {
            zoneNumbers.add(zone.zoneNumber());
        }
        return Collections.unmodifiableList(zoneNumbers);
    }

    public List<ZoneLocation> zoneLocations() {
        List<ZoneLocation> zoneLocations = new ArrayList<>();
        for (Zone zone : this.zones) {
            zoneLocations.add(zone.zoneLocation());
        }
        return Collections.unmodifiableList(zoneLocations);
    }

    private void validateDuplicateZoneNumber(ZoneNumber addZoneNumber) {
        if (zoneNumbers().contains(addZoneNumber)) {
            throw new IllegalArgumentException("존 숫자가 중복입니다.");
        }
    }

    private void validateDuplicateZoneLocation(ZoneLocation addZoneLocation) {
        if (zoneLocations().contains(addZoneLocation)) {
            throw new IllegalArgumentException("존 위치가 중복입니다.");
        }
    }
}
