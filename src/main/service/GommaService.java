package main.service;

import main.dao.GommaDAO;
import main.model.Gomma;

import java.util.List;

public class GommaService {

    private GommaDAO gommaDAO;

    public GommaService() {
        this.gommaDAO = new GommaDAO();
    }

    public List<Gomma> getAllGomme () {
        return this.gommaDAO.getAllGomme();
    }

    public boolean insertGomma (Gomma gomma) {
        return this.gommaDAO.insertGomma(gomma);
    }
    public List<String> getAllManufacturerForTypeVehicle(String type){return this.gommaDAO.getAllManufacturerForTypeVehicle(type);}
    public List<Gomma> getAllGommeForManufacturer(String type,String brand){
        return this.gommaDAO.getAllGommeForManufacturer(type,brand);}
    public List<Gomma> allGommaForAutoAndSize(String type, double width, double height, double diameter, String season){
        return this.gommaDAO.allGommaForAutoAndSize(type,width,height,diameter,season);
    }
    public List<Gomma> allGommaForMotoAndSize(String type, double width, double height, double diameter, double weight, String speed){
        return this.gommaDAO.allGommaForMotoAndSize(type,width,height,diameter,weight,speed);
    }

    public List<Gomma> getGommeFromIdGomme (int idGomme){return this.gommaDAO.getGommeFromIdGomme(idGomme);}
}


