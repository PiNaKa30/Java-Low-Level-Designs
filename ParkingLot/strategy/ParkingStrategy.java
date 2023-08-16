package strategy;

import dto.ParkingResponse;
import vehicle.Vehicle;

import java.util.List;

public interface ParkingStrategy {

    ParkingResponse park(int maxVehicleCapacity, List<Vehicle> parkedVehicles);

}
