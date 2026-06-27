package airtribe.Entity;

import airtribe.Enum.TransactionStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class ParkingTransaction {
    private String id;

    private Vehicle vehicle;

    private ParkingSpot parkingSpot;

    private LocalDateTime entryTime;

    private LocalDateTime exitTime;

    private Double amountCharged;

    private TransactionStatus status;

    public ParkingTransaction(Vehicle vehicle,
                              ParkingSpot parkingSpot) {

        this.id = UUID.randomUUID().toString();;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = LocalDateTime.now();
        this.status = TransactionStatus.ACTIVE;
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public Double getAmountCharged() {
        return amountCharged;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void completeTransaction(double amount) {

        this.exitTime = LocalDateTime.now();
        this.amountCharged = amount;
        this.status = TransactionStatus.COMPLETED;
    }

    @Override
    public String toString() {
        return "ParkingTransaction{" +
                "vehicle=" + vehicle.getLicensePlate() +
                ", parkingSpot=" + parkingSpot.getSpotNumber() +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", amountCharged=" + amountCharged +
                ", status=" + status +
                '}';
    }
}
