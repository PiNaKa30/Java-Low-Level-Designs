import dto.ParkingResponse;
import strategy.ParkingStrategy;
import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private int maxTwoWheelerCapacity;
    private int maxFourWheelerCapacity;
    private List<Vehicle> parkedTwoWheelers;
    private List<Vehicle> parkedFourWheelers;
    private ParkingStrategy twoWheelerParkingStrategy;
    private ParkingStrategy fourWheelerParkingStrategy;

    public ParkingLot(int maxTwoWheelerCapacity, int maxFourWheelerCapacity,
                      ParkingStrategy twoWheelerParkingStrategy, ParkingStrategy fourWheelerParkingStrategy) {
        this.maxTwoWheelerCapacity = maxTwoWheelerCapacity;
        this.maxFourWheelerCapacity = maxFourWheelerCapacity;
        this.twoWheelerParkingStrategy = twoWheelerParkingStrategy;
        this.fourWheelerParkingStrategy = fourWheelerParkingStrategy;
        this.parkedTwoWheelers = new ArrayList<>(maxTwoWheelerCapacity);
        this.parkedFourWheelers = new ArrayList<>(maxFourWheelerCapacity);
        for(int i=0; i<maxTwoWheelerCapacity; i++)
            this.parkedTwoWheelers.add(null);
        for(int i=0; i<maxFourWheelerCapacity; i++)
            this.parkedFourWheelers.add(null);
    }

    public void parkVehicle(Vehicle vehicle){
        ParkingResponse parkingResponse;
        if(vehicle.getType().equals("2W")){
            parkingResponse = twoWheelerParkingStrategy.park(this.maxTwoWheelerCapacity,
                    this.parkedTwoWheelers);
            if(parkingResponse.getErrorMsg() == null){
                this.parkedTwoWheelers.set(parkingResponse.getParkingSpot(), vehicle);
                System.out.println("Parked vehicle at spot :: 2W" + parkingResponse.getParkingSpot());
            } else {
                System.out.println("Couldn't park vehicle :: " + parkingResponse.getErrorMsg());
            }
        } else  {
            parkingResponse = fourWheelerParkingStrategy.park(this.maxFourWheelerCapacity,
                    this.parkedFourWheelers);
            if(parkingResponse.getErrorMsg() == null){
                this.parkedFourWheelers.set(parkingResponse.getParkingSpot(), vehicle);
                System.out.println("Parked vehicle at spot :: 4W" + parkingResponse.getParkingSpot());
            } else {
                System.out.println("Couldn't park vehicle :: " + parkingResponse.getErrorMsg());
            }
        }

    }

    public void unParkVehicle(Vehicle vehicle){
        if(vehicle.getType().equals("2W")) {
            int parkingSpot = this.parkedTwoWheelers.indexOf(vehicle);
            if (parkingSpot == -1) {
                System.out.println("Vehicle not found in Parking Lot");
            } else {
                this.parkedTwoWheelers.set(parkingSpot, null);
                System.out.println("Vehicle removed from spot :: 2W" + parkingSpot);
            }
        } else {
            int parkingSpot = this.parkedFourWheelers.indexOf(vehicle);
            if (parkingSpot == -1) {
                System.out.println("Vehicle not found in Parking Lot");
            } else {
                this.parkedFourWheelers.set(parkingSpot, null);
                System.out.println("Vehicle removed from spot :: 4W" + parkingSpot);
            }
        }
    }

}
