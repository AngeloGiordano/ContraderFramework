package main.view;

import main.MainDispatcher;
import main.controller.Request;
import sun.applet.Main;

import java.util.Scanner;

public class HomeView implements View {

    private int choice;
    private String role;
    private String nomeUtente;
    private String password;


    public void showResults(Request request) {
        if(request!= null)
        {
            role=(String)request.get("role");
            nomeUtente=(String) request.get("nomeUtente");
            password=(String) request.get("password");
        }

    }


    public void showOptions() {
        System.out.println("Benvenuto in ContraderFramework");
        System.out.println("");
        System.out.println("");
        if(role.equals("admin"))
        {

            System.out.println("-------MENU ADMIN-------");
            System.out.println("");
            System.out.println("Benvenuto admin "+nomeUtente);
            System.out.println("Azioni disponibili:");
            System.out.println("1) Inserisci gomma");
            System.out.println("2) Visualizza gomme disponibili");
            System.out.println("3) Visualizza utenti registrati");
            System.out.println("4) Visualizza brand gomma per tipologia veicolo (auto|moto|commerciale)");
            System.out.println("5) Logout");
            this.choice = Integer.parseInt(getInput());}
        else
            if (role.equals("local"))
            {
                System.out.println("-------MENU USER-------");
                System.out.println("Benvenuto utente");
                System.out.println("Azioni disponibili:");
                System.out.println("1) Visualizza gomme disponibili");
                System.out.println("2) Visualizza brand gomma per tipologia veicolo e brand(auto|moto|commerciale)");
                System.out.println("3) Visualizza gomma per tipologia e dimensioni (auto|moto|commerciale)");
                System.out.println("4) Logout");
                this.choice = Integer.parseInt(getInput());
           }
    }

    public void submit() {
        if (role.equals("admin")) {
            if (choice < 1 || choice > 5) {
                Request request = new Request();
                request.put("role", role);
                request.put("nomeUtente", nomeUtente);
                request.put("password", password);
                MainDispatcher.getInstance().callAction("Home", "doControl", request);
            }  if (choice == 5)
                MainDispatcher.getInstance().callAction("Login", "doControl", null);
            if (choice==3) {
                Request request = new Request();
                request.put("choice", choice);
                request.put("role", role);
                request.put("nomeUtente", nomeUtente);
                request.put("password", password);
                MainDispatcher.getInstance().callAction("User","doControl",request);

            }
            else  {
                Request request = new Request();
                request.put("choice", choice);
                request.put("role", role);
                request.put("nomeUtente", nomeUtente);
                request.put("password", password);
                MainDispatcher.getInstance().callAction("Gomma", "doControl", request);

            }
        }  if (role.equals("local")) {
            if (choice < 1 || choice > 4) {
                Request request = new Request();
                request.put("role", role);
                request.put("nomeUtente", nomeUtente);
                request.put("password", password);
                MainDispatcher.getInstance().callAction("Home", "doControl", request);

            } else if (choice == 4)
                MainDispatcher.getInstance().callAction("Login", "doControl", null);
            else {
                Request request = new Request();
                request.put("choice", choice);
                request.put("role", role);
                request.put("nomeUtente", nomeUtente);
                request.put("password", password);
                MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
            }
        }
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
