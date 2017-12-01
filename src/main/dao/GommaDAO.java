package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Gomma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GommaDAO {

    private final String QUERY_ALL = "select * from gomme";
    private final String QUERY_INSERT = "insert into gomme (idGomme,model, manufacturer, price,width,height,diameter,weight,speed,season,typevehicle,quantity) values (null,?,?,?,?,?,?,?,?,?,?,?)";

    public GommaDAO() {

    }

    public List<String> getAllManufacturerForTypeVehicle(String type) {
        List<String> manufacturers = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        String query = "SELECT  DISTINCT manufacturer FROM gomme WHERE typevehicle=\"" + type + "\"";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String manufacturer = resultSet.getString("manufacturer");
                manufacturers.add(manufacturer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manufacturers;

    }

    public List<Gomma> getAllGommeForManufacturer(String type, String brand) {
        List<Gomma> gommeBrand = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        String query_brand = "SELECT * FROM gomme WHERE manufacturer=\"" + brand + "\" AND typevehicle=\"" + type + "\"";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query_brand);
            while (resultSet.next()) {
                int idGomme = resultSet.getInt("idGomme");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                double price = resultSet.getDouble("price");
                double width = resultSet.getDouble("width");
                double height = resultSet.getDouble("height");
                double diameter = resultSet.getDouble("diameter");
                double weight = resultSet.getDouble("weight");
                String speed = resultSet.getString("speed");
                String season = resultSet.getString("season");
                String typevehicle = resultSet.getString("typevehicle");
                int quantity = resultSet.getInt("quantity");
                gommeBrand.add(new Gomma(idGomme, model, manufacturer, price, width, height, diameter, weight, speed, season, typevehicle, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gommeBrand;
    }

    public List<Gomma> getAllGomme() {
        List<Gomma> gomme = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY_ALL);
            while (resultSet.next()) {
                int idGomme = resultSet.getInt("idGomme");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                double price = resultSet.getDouble("price");
                double width = resultSet.getDouble("width");
                double height = resultSet.getDouble("height");
                double diameter = resultSet.getDouble("diameter");
                double weight = resultSet.getDouble("weight");
                String speed = resultSet.getString("speed");
                String season = resultSet.getString("season");
                String typevehicle = resultSet.getString("typevehicle");
                int quantity = resultSet.getInt("quantity");
                gomme.add(new Gomma(idGomme, model, manufacturer, price, width, height, diameter, weight, speed, season, typevehicle, quantity));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gomme;
    }

    public boolean insertGomma(Gomma gomma) {
        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
            preparedStatement.setString(1, gomma.getModel());
            preparedStatement.setString(2, gomma.getManufacturer());
            preparedStatement.setDouble(3, gomma.getPrice());
            preparedStatement.setDouble(4, gomma.getWidth());
            preparedStatement.setDouble(5, gomma.getHeight());
            preparedStatement.setDouble(6, gomma.getDiameter());
            preparedStatement.setDouble(7, gomma.getWeight());
            preparedStatement.setString(8, gomma.getSpeed());
            preparedStatement.setString(9, gomma.getSeason());
            preparedStatement.setString(10, gomma.getTypevehicle());
            preparedStatement.setInt(11, gomma.getQuantity());
            return preparedStatement.execute();
        } catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }

    public List<Gomma> allGommaForAutoAndSize(String type, double width, double height, double diameter, String season) {
        List<Gomma> gommeAuto = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        String query_auto = "SELECT * FROM gomme WHERE typevehicle=\"" + type + "\" AND width=\"" + width + "\" AND height=\"" + height + "\" AND diameter=\"" + diameter + "\" AND season=\"" + season + "\"";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query_auto);
            while (resultSet.next()) {
                int idGomme = resultSet.getInt("idGomme");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                double price = resultSet.getDouble("price");
                double width1 = resultSet.getDouble("width");
                double height1 = resultSet.getDouble("height");
                double diameter1 = resultSet.getDouble("diameter");
                double weight = resultSet.getDouble("weight");
                String speed = resultSet.getString("speed");
                String season1 = resultSet.getString("season");
                String typevehicle = resultSet.getString("typevehicle");
                int quantity = resultSet.getInt("quantity");
                gommeAuto.add(new Gomma(idGomme, model, manufacturer, price, width1, height1, diameter1, weight, speed, season1, typevehicle, quantity));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gommeAuto;
    }

    public List<Gomma> allGommaForMotoAndSize(String type, double width, double height, double diameter, double weight, String speed) {
        List<Gomma> gommeMoto = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        String query_moto = "SELECT * FROM gomme WHERE typevehicle=\"" + type + "\" AND width=\"" + width + "\" AND height=\"" + height + "\" AND diameter=\"" + diameter + "\" AND speed=\"" + speed + "\"";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query_moto);
            while (resultSet.next()) {
                int idGomme = resultSet.getInt("idGomme");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                double price = resultSet.getDouble("price");
                double width2 = resultSet.getDouble("width");
                double height2 = resultSet.getDouble("height");
                double diameter2 = resultSet.getDouble("diameter");
                double weight2 = resultSet.getDouble("weight");
                String speed2 = resultSet.getString("speed");
                String season = resultSet.getString("season");
                String typevehicle = resultSet.getString("typevehicle");
                int quantity = resultSet.getInt("quantity");
                gommeMoto.add(new Gomma(idGomme, model, manufacturer, price, width2, height2, diameter2, weight2, speed2, season, typevehicle, quantity));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gommeMoto;
    }
}
