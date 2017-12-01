package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Gomma;
import main.dao.GommaDAO;
import main.service.GommaService;

import java.util.List;
import java.util.Scanner;

public class GommaView implements View {

    private GommaService gommaService;
    private String mode;
    private String role;
    private String nomeUtente;
    private String password;

  public GommaView () {
      this.gommaService = new GommaService();
      this.mode = "all";
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
        switch (mode) {
            case "all":
                List<Gomma> gomme = gommaService.getAllGomme();
                System.out.println("----- Gomme disponibili -----");
                System.out.println();
                gomme.forEach(gomma -> System.out.println(gomma));
                break;
            case "insert":
                Scanner scanner = new Scanner(System.in);
                System.out.println("Inserisci i dati della nuova gomma:");
                System.out.println("Modello:");
                String model = getInput();
                System.out.println("Produttore:");
                String manufacturer = getInput();
                System.out.println("Prezzo:");
                double price = Double.parseDouble(getInput());
                System.out.println("Larghezza:");
                double width=Double.parseDouble(getInput());
                System.out.println("Altezza:");
                double height=Double.parseDouble(getInput());
                System.out.println("Diametro:");
                double diameter=Double.parseDouble(getInput());
                System.out.println("Carico:");
                double weight=Double.parseDouble(getInput());
                System.out.println("Velocità:");
                String speed=getInput();
                System.out.println("Stagione:");
                String season=getInput();
                System.out.println("Tipo Veicolo:");
                String typevehicle=getInput();
                System.out.println("Quantità: ");
                int quantity=Integer.parseInt(scanner.nextLine());
                gommaService.insertGomma(new Gomma(null,model,manufacturer,price,width,height,diameter,weight,speed,season,typevehicle,quantity));
                break;
            case "allBrandForVehicle":
                System.out.println("Scegli la tipologia (auto|moto|commerciale)");
                String type=getInput();
                List<String> brands= gommaService.getAllManufacturerForTypeVehicle(type);
                System.out.println("----- Brand disponibili -----");
                System.out.println();
                brands.forEach(String -> System.out.println(String));
                System.out.println();
                System.out.print("Scegli il brand: ");
                System.out.print("\n");
                String brand=getInput();
                List<Gomma>gommaBrand=gommaService.getAllGommeForManufacturer(type,brand);
                if (gommaBrand.isEmpty()){
                    System.out.print("Dispiace nessuna gomma disponibile per il brand "+brand+" e la tipologia "+type+"\n");
                }else{
                    System.out.println("Ecco la lista per il brand "+brand+" e per la tipologia "+type);
                    System.out.println();
                    gommaBrand.forEach(gomma->System.out.println(gomma));
                    System.out.print("\n");

                }

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
