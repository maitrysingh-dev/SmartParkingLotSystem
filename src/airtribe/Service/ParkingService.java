package airtribe.Service;

import airtribe.Entity.ParkingSpot;
import airtribe.Entity.ParkingTransaction;
import airtribe.Entity.Vehicle;
import airtribe.Interface.IFeeCalculationInterface;

import java.time.LocalDateTime;

public class ParkingService {

    private ParkingSpotManagerService spotService;

    private ParkingTransactionService transactionService;

    private IFeeCalculationInterface feeStrategy;

    public ParkingService(
            ParkingSpotManagerService spotService,
            ParkingTransactionService transactionService,
            IFeeCalculationInterface feeStrategy) {

        this.spotService = spotService;
        this.transactionService = transactionService;
        this.feeStrategy = feeStrategy;

    }

    public ParkingTransaction checkIn(Vehicle vehicle) {

        ParkingSpot parkingSpot =
                spotService.allocateSpot(vehicle);

        if (parkingSpot == null) {

            throw new RuntimeException(
                    "No Parking Spot Available");

        }

        return transactionService.createTransaction(
                vehicle,
                parkingSpot);

    }

    public ParkingTransaction checkOut(String transactionId) {

        ParkingTransaction transaction =
                transactionService.getActiveTransaction(transactionId);

        if (transaction == null) {

            throw new RuntimeException(
                    "Transaction Not Found");

        }

        double fee =
                feeStrategy.calculateFee(

                        transaction.getEntryTime(),

                        LocalDateTime.now(),

                        transaction.getVehicle().getType()

                );

        transactionService.completeTransaction(
                transaction,
                fee);

        spotService.releaseSpot(
                transaction.getParkingSpot());

        return transaction;

    }

}