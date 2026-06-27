package airtribe.Entity;

import airtribe.Enum.ParkingSpotStatus;
import airtribe.Enum.VehicleType;

import java.util.UUID;

public class ParkingSpot {

    private String id;
    private int spotNumber;
    private VehicleType allowedVehicleType;
    private ParkingSpotStatus status;

    public ParkingSpot(int spotNumber, VehicleType allowedVehicleType) {
        this.id = UUID.randomUUID().toString();;
        this.spotNumber = spotNumber;
        this.allowedVehicleType = allowedVehicleType;
        this.status = ParkingSpotStatus.AVAILABLE;
    }

    public String getId() {
        return id;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getAllowedVehicleType() {
        return allowedVehicleType;
    }

    public ParkingSpotStatus getStatus() {
        return status;
    }

    public void occupy() {
        status = ParkingSpotStatus.OCCUPIED;
    }

    public void release() {
        status = ParkingSpotStatus.AVAILABLE;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "spotNumber=" + spotNumber +
                ", vehicleType=" + allowedVehicleType +
                ", status=" + status +
                '}';
    }
}
