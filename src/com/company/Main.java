package com.company;

import com.company.Classes.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.enums.CarState.BASE;

public class Main {
    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();

    public static final Gson GSON = GSON_BUILDER.setPrettyPrinting().create();

    public static final Path WRITE_PATH = Paths.get("./car.gson");

    public static final Path WRITE_PATH_DRIVER = Paths.get("./driver.gson");


    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
            cars.add(Car.addCar(1, "Renault Magnum", "", BASE));
            cars.add(Car.addCar(2, "Volvo", "", BASE));
            cars.add(Car.addCar(3, "DAF XT", "", BASE));


        List<Drivers> drivers = new ArrayList<>();
                drivers.add(Drivers.addDrivers("driver1", "Petr", ""));
                drivers.add(Drivers.addDrivers("driver2", "Askar", ""));
                drivers.add(Drivers.addDrivers("driver3", "Uson", ""));


        String jsonCar = GSON.toJson(cars);
        setWritePath(jsonCar);
        printCarTable(cars);

        String jsonDriver = GSON.toJson(drivers);
        setWritePathDriver(jsonDriver);
        System.out.println();
        System.out.println("************************************************");
        printDriverTable(drivers);

        System.out.println();
        System.out.println("*************************************************");

        Service service = new Service();
        Scanner scanner = new Scanner(System.in);

        for (;true;) {
            System.out.println("""
                    To change driver press 1
                    To send truck to road press 2
                    To send truck to repair press 3
                    If you want to quit press 0""");
            int input = scanner.nextInt();
            if (input == 1) {
                try{
                    System.out.println("Select drivers id");
                    int inputId = scanner.nextInt();
                    service.changeDriver(drivers.get(inputId - 1), cars.get(inputId - 1));
                    printCarTable(cars);
                    printDriverTable(drivers);
                }
                catch (ChangeDriverException e) {
                    System.err.println(e.getMessage());
                }

            }
            if (input == 2) {
                try {
                    System.out.println("Select truck's ID");
                    int inputId = scanner.nextInt();
                    service.startDriving(drivers.get(inputId - 1), cars.get(inputId - 1));
                    System.out.println(cars.get(inputId - 1));
                    printCarTable(cars);
                    printDriverTable(drivers);
                }
                catch (CarStateException e) {
                    System.err.println(e.getMessage());
                }
            }
            if (input == 3) {
                try{
                    System.out.println("Select truck's ID");
                    int inputId = scanner.nextInt();
                    service.startRepair(drivers.get(inputId - 1), cars.get(inputId - 1));
                    System.out.println(cars.get(inputId - 1));
                    printCarTable(cars);
                    printDriverTable(drivers);
                }
                catch (IndexOutOfBoundsException e) {
                    System.err.println("You wrote the wrong number! Please can you write again");
                }
            }
            if (input == 0) {
                System.out.println("Thank You!");
                break;
            }
        }


    }

    private static void setWritePath(String object){
    Path setWritePath = Paths.get(String.valueOf(WRITE_PATH));
    try {
        Files.writeString(setWritePath, object, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
    } catch (IOException e){
        System.err.println(e.getMessage());
    }
    }

    private static void setWritePathDriver(String object){
        Path setWritePathDriver = Paths.get(String.valueOf(WRITE_PATH_DRIVER));
        try {
            Files.writeString(setWritePathDriver, object, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    private static String readFile() {
        String json = "";
        try {
            FileReader fileReader = new FileReader(String.valueOf(WRITE_PATH));
            int temp;
            while ((temp = fileReader.read()) != -1) {
                json += (char) temp;
            }
            return json;
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return json;
    }

    public static void printCarTable(List<Car> cars){
        System.out.println();
        System.out.println("-------------------------- Cars --------------------------");
        System.out.println("#      | Bus                 |  Driver            |  State");
        System.out.println("_______+_____________________+____________________+_______");
        int counter = 1, tabsBus = 20, tabsDriver = 18, tabsState = 14;
        for(Car i: cars) {
            System.out.print("   " + counter + "   | ");
            System.out.print(i.getName());
            for(int j = 0; j < tabsBus - i.getName().length(); j++) {
                System.out.print(" ");
            }
            System.out.print("|  " + i.getDriver());
            for(int j = 0; j < tabsDriver - i.getDriver().length(); j++) {
                System.out.print(" ");
            }
            System.out.print("|  ");
            System.out.print(i.getCarState());
            for(int j = 0; j < tabsState - i.getCarState().toString().length(); j++) {
                System.out.print(" ");
            }
            counter++;
            System.out.println();
        }
    }

    public static void printDriverTable(List<Drivers> drivers) {
        System.out.println();
        System.out.println("-----------  DRIVERS  -----------");
        System.out.println("   #   |  Driver             |  Bus               ");
        System.out.println("-------+---------------------+--------------------");
        int counter = 1, tabsDriver = 20, tabsBus = 18;
        for (Drivers i : drivers) {
            System.out.print("   " + counter + "   | ");
            System.out.print(i.getName());
            for (int j = 0; j < tabsDriver - i.getName().length(); j++) {
                System.out.print(" ");
            }
            System.out.print("|  " + i.getBus());
            for (int j = 0; j < tabsDriver - i.getName().length(); j++) {
                System.out.print(" ");
            }
            counter++;
            System.out.println();
        }
    }
}