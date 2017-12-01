package main.controller;

import main.MainDispatcher;

public class GommaController implements Controller {


    @Override
    public void doControl(Request request) {
        int choice = (int) request.get("choice");
        String role = (String) request.get("role");
        if (role.equals("admin")) {
            switch (choice) {
                case 1:
                    request.put("mode", "insert");
                    break;
                case 2:
                    request.put("mode", "all");
                    break;
                case 4:
                    request.put("mode", "allBrandForVehicle");
                    break;
            }
            MainDispatcher.getInstance().callView("Gomma", request);

        }
        if (role.equals("local")) {
            switch (choice) {
                case 1:
                    request.put("mode", "all");
                    break;
                case 2:
                    request.put("mode", "allBrandForVehicle");
                    break;
                case 3:
                    request.put("mode","allGommaForVehicleAndSize");
                    break;
            }
            MainDispatcher.getInstance().callView("Gomma", request);
        }
    }
}
