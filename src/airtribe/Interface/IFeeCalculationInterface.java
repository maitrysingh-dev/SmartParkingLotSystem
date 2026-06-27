package airtribe.Interface;

import airtribe.Enum.VehicleType;

import java.time.LocalDateTime;

public interface IFeeCalculationInterface {

    double calculateFee(
            LocalDateTime entryTime,
            LocalDateTime exitTime,
            VehicleType vehicleType
    );
}
