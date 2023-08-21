package strategy;

import entity.ParkingSlot;
import entity.Vehicle;

import java.util.List;

public class SmallestFirstParkingStrategy implements ParkingStrategy{

    @Override
    public int park(Vehicle vehicle, List<ParkingSlot> parkingSlots) {
        for(int i=0; i<parkingSlots.size(); i++){
            if(parkingSlots.get(i).isFree()
                    && parkingSlots.get(i).getVehicleType().equals(vehicle.getVehicleType()))
                return i;
        }
        return -1;
    }

}
