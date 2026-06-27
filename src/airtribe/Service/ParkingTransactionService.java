package airtribe.Service;

import airtribe.Entity.ParkingSpot;
import airtribe.Entity.ParkingTransaction;
import airtribe.Entity.Vehicle;
import airtribe.Enum.TransactionStatus;
import airtribe.Repository.ParkingRepository;

public class ParkingTransactionService {

    private ParkingRepository repository;

    public ParkingTransactionService(ParkingRepository repository) {

        this.repository = repository;

    }

    public ParkingTransaction createTransaction(Vehicle vehicle,
                                                ParkingSpot parkingSpot) {

        ParkingTransaction transaction =
                new ParkingTransaction(vehicle, parkingSpot);

        repository.getTransactions().add(transaction);

        return transaction;
    }

    public ParkingTransaction getActiveTransaction(String transactionId) {

        for (ParkingTransaction transaction :
                repository.getTransactions()) {

            if (transaction.getId().equals(transactionId)
                    && transaction.getStatus() == TransactionStatus.ACTIVE) {

                return transaction;

            }

        }

        return null;

    }

    public void completeTransaction(ParkingTransaction transaction,
                                    double amount) {

        transaction.completeTransaction(amount);

    }

}