package airtribe.Strategies;

import airtribe.Enum.VehicleType;
import airtribe.Interface.IFeeCalculationInterface;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyBasisFeeStrategy implements IFeeCalculationInterface{

    @Override
    public double calculateFee(LocalDateTime entryTime,
                               LocalDateTime exitTime,
                               VehicleType vehicleType) {

        long hours = Duration.between(entryTime, exitTime).toHours();

        if (Duration.between(entryTime, exitTime).toMinutes() % 60 != 0) {
            hours++;
        }

        if (hours == 0) {
            hours = 1;
        }

        double hourlyRate;

        switch (vehicleType) {

            case MOTORCYCLE:
                hourlyRate = 10;
                break;

            case CAR:
                hourlyRate = 20;
                break;

            default:
                throw new IllegalArgumentException("Invalid Vehicle Type");
        }

        return hours * hourlyRate;
    }
}

