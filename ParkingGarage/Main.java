import entity.ParkingGarage;
import entity.Vehicle;
import enums.VehicleType;
import strategy.LargestFirstParkingStrategy;
import strategy.SmallestFirstParkingStrategy;

public class Main {

    public static void main(String[] args) {

//        Creating garage with initial capacities and strategy
        ParkingGarage parkingGarage = new ParkingGarage(2,2,2,
                new LargestFirstParkingStrategy());

//        Creating vehicles of different types
        Vehicle v1 = new Vehicle("2WV-1", VehicleType.TWO_WHEELER);
        Vehicle v2 = new Vehicle("2WV-2", VehicleType.TWO_WHEELER);
        Vehicle v3 = new Vehicle("2WV-3", VehicleType.TWO_WHEELER);

        Vehicle v4 = new Vehicle("SMV-1", VehicleType.SMALL);
        Vehicle v5 = new Vehicle("SMV-2", VehicleType.SMALL);
        Vehicle v6 = new Vehicle("SMV-3", VehicleType.SMALL);

        Vehicle v7 = new Vehicle("LGV-1", VehicleType.LARGE);
        Vehicle v8 = new Vehicle("LGV-2", VehicleType.LARGE);
        Vehicle v9 = new Vehicle("LGV-3", VehicleType.LARGE);

        Vehicle[] vehicles = {v1, v2, v3, v4, v5, v6, v7, v8, v9};

//        Every 3rd vehicle shouldn't get parked
        for(Vehicle vehicle: vehicles){
            parkingGarage.parkVehicle(vehicle);
        }

//        Vehicle shouldn't be found
        parkingGarage.unParkVehicle(v3);
        parkingGarage.unParkVehicle(v6);
        parkingGarage.unParkVehicle(v9);

//        Vehicles should successfully be removed
        parkingGarage.unParkVehicle(v1);
        parkingGarage.unParkVehicle(v5);
        parkingGarage.unParkVehicle(v7);

//        Slot now available to park
        parkingGarage.parkVehicle(v3);
        parkingGarage.parkVehicle(v6);
        parkingGarage.parkVehicle(v9);

    }
}
