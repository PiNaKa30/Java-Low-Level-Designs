package strategy;

import entity.ParkingSlot;
import entity.Vehicle;

import java.util.List;

public interface ParkingStrategy {

    int park(Vehicle vehicle, List<ParkingSlot> parkingSlots);

}
