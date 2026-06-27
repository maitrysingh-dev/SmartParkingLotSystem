package airtribe.Repository;

import airtribe.Entity.ParkingSpot;
import airtribe.Entity.ParkingTransaction;

import java.util.ArrayList;
import java.util.List;

public class ParkingRepository {

    private List<ParkingSpot> parkingSpots;
    private List<ParkingTransaction> transactions;

    public ParkingRepository() {

        parkingSpots = new ArrayList<>();
        transactions = new ArrayList<>();

    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public List<ParkingTransaction> getTransactions() {
        return transactions;
    }
}
