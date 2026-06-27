package airtribe.Service;

import airtribe.Entity.ParkingSpot;
import airtribe.Entity.Vehicle;
import airtribe.Enum.ParkingSpotStatus;
import airtribe.Repository.ParkingRepository;

public class ParkingSpotManagerService {

    private ParkingRepository repository;

    public ParkingSpotManagerService(ParkingRepository repository) {
        this.repository = repository;
    }

    public ParkingSpot allocateSpot(Vehicle vehicle) {

        for (ParkingSpot spot : repository.getParkingSpots()) {

            if (spot.getStatus() == ParkingSpotStatus.AVAILABLE &&
                    spot.getAllowedVehicleType() == vehicle.getType()) {

                spot.occupy();

                return spot;
            }
        }

        return null;
    }

    public void releaseSpot(ParkingSpot parkingSpot) {

        parkingSpot.release();

    }
}
