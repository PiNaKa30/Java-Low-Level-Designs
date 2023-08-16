package strategy;

import dto.ParkingResponse;
import vehicle.Vehicle;

import java.util.List;

public class DecreasingOrderParkingStrategy implements ParkingStrategy{

    @Override
    public ParkingResponse park(int maxVehicleCapacity, List<Vehicle> parkedVehicles) {
        ParkingResponse parkingResponse = new ParkingResponse();
        for(int i = maxVehicleCapacity - 1; i >= 0; i--){
            if(parkedVehicles.get(i) == null){
                parkingResponse.setParkingSpot(i);
                return parkingResponse;
            }
        }
        parkingResponse.setErrorMsg("All spaces full");
        return parkingResponse;
    }

}
