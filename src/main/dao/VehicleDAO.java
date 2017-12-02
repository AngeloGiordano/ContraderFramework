package main.dao;
import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class VehicleDAO {

    public VehicleDAO() {

    }

    public List<Vehicle> getAllVehicle() {
        List<Vehicle> veicolo = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        String queryVehicleAll = "SELECT * FROM vehicle";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryVehicleAll);
            while (resultSet.next()) {
                int idVehicle = resultSet.getInt("idVehicle");
                String brand = resultSet.getString("brand");
                String model = resultSet.getString("model");
                String power = resultSet.getString("power");
                String version = resultSet.getString("version");
                String capacity = resultSet.getString("capacity");
                veicolo.add(new Vehicle(idVehicle, brand, model, power, version, capacity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veicolo;
    }

    public boolean insertVehicle(Vehicle vehicle){
        Connection connection=ConnectionSingleton.getInstance();
        String queryinsertVehicle="INSERT INTO vehicle (idVehicle,brand,model,power,version,capacity) values(null,?,?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(queryinsertVehicle);
            preparedStatement.setString(1,vehicle.getBrand());
            preparedStatement.setString(2,vehicle.getModel());
            preparedStatement.setString(3,vehicle.getPower());
            preparedStatement.setString(4,vehicle.getVersion());
            preparedStatement.setString(5,vehicle.getCapacity());
            return preparedStatement.execute();

        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }
    }

    public int getIdVehiclefromAuto (String brand,String model,String power, String version,String capacity) {
        int id=0;
        Connection connection = ConnectionSingleton.getInstance();
        String queryIdfromAuto = "Select idVehicle from vehicle WHERE brand=\"" + brand + "\" AND model=\"" + model + "\"AND power=\"" + power + "\"AND version=\"" + version + "\"AND capacity=\"" + capacity + "\"";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryIdfromAuto);
            while (resultSet.next()) {
                int idVehicle=resultSet.getInt("IdVehicle");
                id=idVehicle;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public Vector getIdGommeFromIdVehicle(int idVehicle){
        Vector idGList= new Vector<>();
        Connection connection = ConnectionSingleton.getInstance();
        String queryIdGfromIdV="SELECT idGomme FROM compatibility WHERE idVehicle=\""+idVehicle+"\"";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryIdGfromIdV);
            while (resultSet.next()) {
                int idGomme=resultSet.getInt("IdGomme");
                idGList.add(idGomme);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idGList;
    }



}

