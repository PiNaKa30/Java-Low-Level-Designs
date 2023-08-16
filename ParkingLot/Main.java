import strategy.DecreasingOrderParkingStrategy;
import strategy.IncreasingOrderParkingStrategy;
import vehicle.FourWheelerVehicle;
import vehicle.TwoWheelerVehicle;
import vehicle.Vehicle;

public class Main {

    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot(2,3,
                new IncreasingOrderParkingStrategy(), new DecreasingOrderParkingStrategy());

        Vehicle v1 = new TwoWheelerVehicle();
        Vehicle v2 = new TwoWheelerVehicle();
        Vehicle v3 = new TwoWheelerVehicle();

        Vehicle v4 = new FourWheelerVehicle();
        Vehicle v5 = new FourWheelerVehicle();
        Vehicle v6 = new FourWheelerVehicle();
        Vehicle v7 = new FourWheelerVehicle();

        parkingLot.parkVehicle(v1);
        parkingLot.parkVehicle(v2);
        parkingLot.parkVehicle(v3);
        parkingLot.parkVehicle(v4);
        parkingLot.parkVehicle(v5);
        parkingLot.parkVehicle(v6);
        parkingLot.parkVehicle(v7);
        parkingLot.unParkVehicle(v3);
        parkingLot.unParkVehicle(v7);
        parkingLot.unParkVehicle(v1);
        parkingLot.parkVehicle(v3);
        parkingLot.unParkVehicle(v5);
        parkingLot.parkVehicle(v7);

    }
}
