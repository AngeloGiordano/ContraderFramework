package main.controller;

import main.MainDispatcher;

public class UserController implements Controller {
    @Override
    public void doControl(Request request) {
        int choice =(int) request.get("choice");


        switch (choice){
            case 0:
                request.put("mode", "insert");
                break;
            case 3:
                request.put("mode","viewUser");
                break;

        }
        MainDispatcher.getInstance().callView("User", request);
    }
}
