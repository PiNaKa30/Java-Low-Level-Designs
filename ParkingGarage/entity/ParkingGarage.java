package entity;

import enums.VehicleType;
import strategy.ParkingStrategy;
import java.util.ArrayList;
import java.util.List;

public class ParkingGarage {

    private int twoWheelerSlots;
    private int smallSlots;
    private int largeSlots;
    private List<ParkingSlot> parkingSlots;
    private ParkingStrategy parkingStrategy;

    public ParkingGarage(int twoWheelerSlots, int smallSlots, int largeSlots, ParkingStrategy parkingStrategy) {
        this.twoWheelerSlots = twoWheelerSlots;
        this.smallSlots = smallSlots;
        this.largeSlots = largeSlots;
        this.parkingStrategy = parkingStrategy;
        this.parkingSlots = new ArrayList<>(twoWheelerSlots + smallSlots + largeSlots);
        initParkingSlots("2W-", twoWheelerSlots, VehicleType.TWO_WHEELER);
        initParkingSlots("SM-", smallSlots, VehicleType.SMALL);
        initParkingSlots("LG-", largeSlots, VehicleType.LARGE);
    }

    private void initParkingSlots(String slotPrefix, int slotCount, VehicleType vehicleType) {
        for (int i=0; i<slotCount; i++){
            ParkingSlot parkingSlot = new ParkingSlot(slotPrefix + i, vehicleType);
            parkingSlot.setFree(true);
            parkingSlot.setVehicle(null);
            parkingSlots.add(parkingSlot);
        }
    }

    private int getIndexOfParkedVehicle(Vehicle vehicle){
        for(int i=0; i<parkingSlots.size(); i++){
            if(!parkingSlots.get(i).isFree()
                    && parkingSlots.get(i).getVehicle().equals(vehicle))
                return i;
        }
        return -1;
    }

    public void parkVehicle(Vehicle vehicle){
        int index = parkingStrategy.park(vehicle, parkingSlots);
        if(index == -1){
            System.out.println("No suitable slot found");
        } else {
            ParkingSlot slot = parkingSlots.get(index);
            slot.setFree(false);
            slot.setVehicle(vehicle);
            parkingSlots.set(index, slot);
            System.out.println("Parked vehicle at: " + slot.getSlotId());
        }
    }

    public void unParkVehicle(Vehicle vehicle){
        int index = getIndexOfParkedVehicle(vehicle);
        if(index == -1){
            System.out.println("Vehicle not found");
        } else {
            ParkingSlot slot = parkingSlots.get(index);
            slot.setFree(true);
            slot.setVehicle(null);
            parkingSlots.set(index, slot);
            System.out.println("Removed vehicle from: " + slot.getSlotId());
        }
    }

}
