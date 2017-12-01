package main.view;

import main.MainDispatcher;
import main.controller.Request;

import java.util.Scanner;

public class LoginView implements View {

    private String nomeUtente;
    private String password;
    private int scelta;

    public void showResults (Request request) {

    }


    public void showOptions () {

        System.out.print("DIGITA: 1-->ACCEDI      2-->REGISTRAZIONE ");
        Scanner in=new Scanner(System.in);
        scelta=Integer.parseInt(in.nextLine());
        if(scelta==1){
        System.out.println("-----LOGIN----");
        System.out.println("Nome utente:");
        nomeUtente = getInput();
        System.out.println("Password:");
        password = getInput();}
    }

    public void submit() {
        Request request = new Request();
        request.put("scelta",scelta);
        if (scelta==1){
        request.put("nomeUtente", nomeUtente);
        request.put("password", password);
        MainDispatcher.getInstance().callAction("Home", "doControl", request);}
        if(scelta==2){
            int choice= 0;
            request.put("choice",choice);
            MainDispatcher.getInstance().callAction("User", "doControl", request);
        }
        if(scelta<1 || scelta>2){
            MainDispatcher.getInstance().callAction("Login", "doControl", null);
        }
    }


    public String getInput () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    protected void send () {
    }


}
