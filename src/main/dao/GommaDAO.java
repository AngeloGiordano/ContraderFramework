package main.dao;

import main.ConnectionSingleton;
import main.controller.GestoreEccezioni;
import main.model.Gomma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GommaDAO {

    private final String QUERY_ALL = "select * from gomme";
    private final String QUERY_INSERT = "insert into gomme (idGomme,model, manufacturer, price,width,height,diameter,weight,speed,season,typevehicle) values (null,?,?,?,?,?,?,?,?,?,?)";

    public GommaDAO() {

    }
    public List<String> getAllManufacturerForTypeVehicle(String type){
        List<String> manufacturers= new ArrayList<>();
        Connection connection=ConnectionSingleton.getInstance();
        String query="SELECT  DISTINCT manufacturer FROM gomme WHERE typevehicle=\""+type+"\"";
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String manufacturer= resultSet.getString("manufacturer");
                manufacturers.add(manufacturer);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return manufacturers;

    }
    public List<Gomma> getAllGommeForManufacturer(String type,String brand){
        List<Gomma> gommeBrand= new ArrayList<>();
        Connection connection= ConnectionSingleton.getInstance();
        String query_brand="SELECT * FROM gomme WHERE manufacturer=\""+brand+"\" AND typevehicle=\""+type+"\"";
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query_brand);
            while (resultSet.next()){
                int idGomme= resultSet.getInt( "idGomme");
                String model = resultSet.getString("model");
                String manufacturer = resultSet.getString("manufacturer");
                double price = resultSet.getDouble("price");
                double width = resultSet.getDouble("width");
                double height = resultSet.getDouble("height");
                double diameter = resultSet.getDouble("diameter");
                double weight = resultSet.getDouble("weight");
                String speed= resultSet.getString( "speed");
                String season= resultSet.getString( "season");
                String typevehicle= resultSet.getString( "typevehicle");
                gommeBrand.add(new Gomma(idGomme,model,manufacturer,price,width,height,diameter,weight,speed,season,typevehicle));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return gommeBrand;
    }
    public List<Gomma> getAllGomme () {
        List<Gomma> gomme = new ArrayList<>();
        Connection connection = ConnectionSingleton.getInstance();
        try {
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(QUERY_ALL);
           while (resultSet.next()) {
               int idGomme= resultSet.getInt( "idGomme");
               String model = resultSet.getString("model");
               String manufacturer = resultSet.getString("manufacturer");
               double price = resultSet.getDouble("price");
               double width = resultSet.getDouble("width");
               double height = resultSet.getDouble("height");
               double diameter = resultSet.getDouble("diameter");
               double weight = resultSet.getDouble("weight");
               String speed= resultSet.getString( "speed");
               String season= resultSet.getString( "season");
               String typevehicle= resultSet.getString( "typevehicle");
               gomme.add(new Gomma(idGomme,model,manufacturer,price,width,height,diameter,weight,speed,season,typevehicle));
           }
        }
        catch (SQLException e) {
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
            return preparedStatement.execute();
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return false;
        }

    }
}
