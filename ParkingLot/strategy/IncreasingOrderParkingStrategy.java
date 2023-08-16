package strategy;

import dto.ParkingResponse;
import vehicle.Vehicle;

import java.util.List;

public class IncreasingOrderParkingStrategy implements ParkingStrategy{

    @Override
    public ParkingResponse park(int maxVehicleCapacity, List<Vehicle> parkedVehicles) {
        ParkingResponse parkingResponse = new ParkingResponse();
        for(int i = 0; i<maxVehicleCapacity; i++){
            if(parkedVehicles.get(i) == null){
                parkingResponse.setParkingSpot(i);
                return parkingResponse;
            }
        }
        parkingResponse.setErrorMsg("All spaces full");
        return parkingResponse;
    }

}
