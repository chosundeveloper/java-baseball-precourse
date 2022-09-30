package baseball.zone;

public class Zone {

    private final ZoneNumber zoneNumber;
    private final ZoneLocation zoneLocation;

    public Zone(ZoneNumber zoneNumber, ZoneLocation zoneLocation) {
        this.zoneNumber = zoneNumber;
        this.zoneLocation = zoneLocation;
    }

    public ZoneNumber zoneNumber() {
        return this.zoneNumber;
    }

    public ZoneLocation zoneLocation() {
        return this.zoneLocation;
    }

}
