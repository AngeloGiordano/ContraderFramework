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
    public List<Gomma> getAllGommeForManufacturer(String type,String brand){return this.gommaDAO.getAllGommeForManufacturer(type,brand);}
}


