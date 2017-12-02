package main.view;

import jdk.nashorn.internal.runtime.arrays.ArrayIndex;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Vehicle;
import main.service.VehicleService;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import main.model.Gomma;
import main.service.GommaService;

public class VehicleView implements View {
    private String mode;
    private VehicleService vehicleService;
    private String role;
    private String nomeUtente;
    private String password;
    private GommaService gommaService;


    public VehicleView(){
        this.vehicleService=new VehicleService();
        this.mode="insert";

    }
    @Override
    public void showResults(Request request) {
        this.mode  = (String) request.get("mode");
        role=(String)request.get("role");
        nomeUtente= (String)request.get("nomeUtente");
        password= (String)request.get("password");

    }

    @Override
    public void showOptions() {
        switch(mode){
            case "insert":
                        System.out.print("Inserisci il Brand: ");
                        String brand=getInput();
                        System.out.print("Inserisci il modello: ");
                        String model=getInput();
                        System.out.print("Inserisci tipo alimentazione: ");
                        String power=getInput();
                        System.out.print("Inserisci versione: ");
                        String version=getInput();
                        System.out.print("Inserisci la cilindrata: ");
                        String capacity=getInput();
                        vehicleService.insertVehicle(new Vehicle(null,brand,model,power,version,capacity));
                        break;
            case "all":
                List <Vehicle> vehicles=vehicleService.getAllVehicle();
                System.out.println("-----VEICOLI DISPONIBILI-----");
                System.out.println();
                vehicles.forEach(vehicle -> System.out.println(vehicle));
                break;
            case "getIdVehicleFromModel":
                System.out.println("----Trova la tua auto----");
                System.out.print("Dimmi la marca: ");
                String brand1=getInput();
                System.out.print("Dimmi il modello: ");
                String model1=getInput();
                System.out.print("Tipo Alimentazione  : ");
                String power1=getInput();
                System.out.print("Dimmi la versione: ");
                String version1=getInput();
                System.out.print("Infine, dimmi la cilindrata: ");
                String capacity1=getInput();
                int id=vehicleService.getIdVehiclefromAuto(brand1,model1,power1,version1,capacity1);
                Vector idGommes=vehicleService.getIdGommeFromIdVehicle(id);
                int dim=idGommes.size();
                int [] indici=new int [dim];
                System.out.println("Il mio array"); //da rimuovere

                for (int i=0;i<idGommes.size();i++){
                    indici[i]=(int) idGommes.elementAt(i);}
                    for(int i=0;i<indici.length;i++){
                    System.out.print(indici[i]);
                    System.out.print("\n");
                }
                System.out.println("-----Gomme disponibili-----");

               List<Gomma> gommacompatibility=gommaService.getGommeFromIdGomme(1);
                   gommacompatibility.forEach(gomma -> System.out.println(gomma));
                   break;



        }

    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }

    @Override
    public void submit() {
        Request request = new Request();
        request.put("role", role);
        request.put("nomeUtente", nomeUtente);
        request.put("password", password);
        MainDispatcher.getInstance().callAction("Home", "doControl", request);

    }
}
