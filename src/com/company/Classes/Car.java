package com.company.Classes;

import com.company.enums.CarState;

public class Car {
    private int id;
    private String name;
    private String driver;
    private CarState CarState;

    public Car(int id, String name, String driver, com.company.enums.CarState carState) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        CarState = carState;
    }

    public Car() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public com.company.enums.CarState getCarState() {
        return CarState;
    }

    public void setCarState(com.company.enums.CarState carState) {
        CarState = carState;
    }

    //    public Car(int id, String name, String driver, CarState CarState) {
//        this.id = id;
//        this.name = name;
//        this.driver = driver;
//        this.CarState = CarState;
//    }
//
//    public Car() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDriver() {
//        return driver;
//    }
//
//    public void setDriver(String driver) {
//        this.driver = driver;
//    }
//
//    public CarState getCarState() {
//        return CarState;
//    }
//
//    public void setCarState(CarState carState) {
//    }

    @Override
    public String toString() {
        return "Car{" + "\n" +
                "id=" + id + "\n"+
                "name='" + name + "\n" +
                "driver='" + driver + "\n" +
                "state='" + CarState + "\n" +
                '}';
    }

    public static Car addCar(int id, String name, String driver, CarState CarState) {
        Car car = new Car();
        car.id = id;
        car.name = name;
        car.driver = driver;
        car.CarState = CarState;
        return car;
    }



}
