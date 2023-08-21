package strategy;

import entity.ParkingSlot;
import entity.Vehicle;

import java.util.List;

public class LargestFirstParkingStrategy implements ParkingStrategy{

    @Override
    public int park(Vehicle vehicle, List<ParkingSlot> parkingSlots) {
        for(int i=parkingSlots.size() - 1; i>=0; i--){
            if(parkingSlots.get(i).getVehicle() == null
                    && parkingSlots.get(i).getVehicleType().equals(vehicle.getVehicleType()))
                return i;
        }
        return -1;
    }

}
