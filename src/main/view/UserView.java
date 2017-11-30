package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.service.UserService;

import java.util.Scanner;
import main.model.User;

public class UserView implements View{
    private String mode;
    private UserService userService;
    private String role;
    private String username;
    private String password;

        public UserView()
        {
            this.userService= new UserService();
            this.mode="insert";
        }


    @Override
    public void showResults(Request request) {
        this.mode  = (String) request.get("mode");

    }

    @Override
    public void showOptions() {
        switch (mode){
            case "insert":
                Scanner scanner = new Scanner(System.in);
                System.out.println("-----Benvenuto nuovo utente-----");
                System.out.println("Compila i seguenti dati per la registrazione: ");
                System.out.print("USERNAME: ");
                 username=getInput();
                System.out.print("PASSWORD: ");
                password=getInput();
                System.out.print("NOME: ");
                String firstname=getInput();
                System.out.print("COGNOME: ");
                String lastname=getInput();
                System.out.print("DATA DI NASCITA [gg/mm/yyyy]: ");
                String dateofbirth=getInput();
                System.out.print("CODICE FISCALE: ");
                String  cf=getInput();
                System.out.print("RAGIONE SOCIALE: ");
                String businessname=getInput() ;
                System.out.print("P.IVA: ");
                String vat=getInput();
                System.out.print("COMUNE: ");
                String municipality=getInput();
                System.out.print("CAP: ");
                String cap=getInput();
                System.out.print("PROVINCIA: ");
                String city=getInput();
                System.out.print("INDIRIZZO: ");
                String address=getInput();
                System.out.print("TELEFONO: ");
                String telephone=getInput();
                role="local";
                userService.insertUser(new User(null,username,password,firstname,lastname,dateofbirth,cf,businessname,vat,municipality,cap,city,address,telephone,""));
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
        request.put("nomeUtente",username);
        request.put("password",password);
        MainDispatcher.getInstance().callAction("Home", "doControl", request);
    }
    }

