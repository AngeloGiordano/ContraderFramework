package main.service;

import main.dao.VehicleDAO;
import main.model.Vehicle;
import java.util.List;
import java.util.*;

public class VehicleService {

    private VehicleDAO vehicleDAO;

    public VehicleService() {
        this.vehicleDAO = new VehicleDAO();
    }

    public boolean insertVehicle(Vehicle vehicle) {
        return this.vehicleDAO.insertVehicle(vehicle);
    }

    public List<Vehicle> getAllVehicle() {
        return this.vehicleDAO.getAllVehicle();
    }

    public int getIdVehiclefromAuto(String brand, String model, String power, String version, String capacity) {
        return this.vehicleDAO.getIdVehiclefromAuto(brand, model, power, version, capacity);
    }

    public Vector getIdGommeFromIdVehicle(int idVehicle) {
        return this.vehicleDAO.getIdGommeFromIdVehicle(idVehicle);
    }
}
