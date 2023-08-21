package entity;

import enums.VehicleType;

public class ParkingSlot {

    private final String slotId;
    private final VehicleType vehicleType;
    private boolean isFree;
    private Vehicle vehicle;

    public ParkingSlot(String slotId, VehicleType vehicleType) {
        this.slotId = slotId;
        this.vehicleType = vehicleType;
    }

    public String getSlotId() {
        return slotId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
