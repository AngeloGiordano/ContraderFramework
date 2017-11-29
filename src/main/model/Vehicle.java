package main.model;

public class Vehicle {

    private int idVehicle ;
    private String brand ;
    private String model ;
    private String power ;
    private String version;
    private String capacity;

    public Vehicle(int idVehicle, String brand, String model, String power, String version, String capacity) {
        this.idVehicle = idVehicle;
        this.brand = brand;
        this.model = model;
        this.power = power;
        this.version = version;
        this.capacity = capacity;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehicle vehicle = (Vehicle) o;

        if (brand != null ? !brand.equals(vehicle.brand) : vehicle.brand != null) return false;
        if (model != null ? !model.equals(vehicle.model) : vehicle.model != null) return false;
        if (power != null ? !power.equals(vehicle.power) : vehicle.power != null) return false;
        if (version != null ? !version.equals(vehicle.version) : vehicle.version != null) return false;
        return capacity != null ? capacity.equals(vehicle.capacity) : vehicle.capacity == null;
    }

    @Override
    public int hashCode() {
        int result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (power != null ? power.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vehicle: " +
                "\n idVehicle: " + idVehicle +
                "\n brand=: " + brand  +
                "\n model='" + model  +
                "\n power: " + power  +
                "\n version: " + version +
                "\n capacity: " + capacity ;
    }
}
