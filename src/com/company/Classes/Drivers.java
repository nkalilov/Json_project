package com.company.Classes;

public class Drivers {
    private String id, drivers_name, bus;



    public Drivers(String id, String name, String bus) {
        this.id = id;
        this.drivers_name = name;
        this.bus = bus;
    }

    public Drivers() {

    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return drivers_name;
    }

    public void setName(String name) {
        this.drivers_name = name;
    }

    @Override
    public String toString() {
        return "Drivers{" +
                "id='" + id + "\n" +
                "drivers_name='" + drivers_name + "\n" +
                "bus='" + bus + "\n" +
                '}';
    }

    public static Drivers addDrivers(String id, String name, String bus) {
        Drivers drivers = new Drivers();
        drivers.id = id;
        drivers.drivers_name = name;
        drivers.bus = bus;
        return drivers;
    }
}
