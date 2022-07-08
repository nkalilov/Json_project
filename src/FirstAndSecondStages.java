import Classes.Car;
import Classes.Drivers;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FirstAndSecondStages {
    public static final GsonBuilder GSON_BUILDER = new GsonBuilder();

    public static final Gson GSON = GSON_BUILDER.setPrettyPrinting().create();

    public static final Path WRITE_PATH = Paths.get("./car.gson");

    public static final Path WRITE_PATH_DRIVER = Paths.get("./driver.gson");


    public static void main(String[] args) {

    Car [] cars = {
            Car.addCar(1, "Renault Magnum", "", "base"),
            Car.addCar(2, "Volvo", "", "base"),
            Car.addCar(3, "DAF XT", "", "base")
    };

        Drivers [] drivers = {
                Drivers.addDrivers("driver1", "Petr", ""),
                Drivers.addDrivers("driver2", "Askar", ""),
                Drivers.addDrivers("driver3", "Uson", ""),
        };

        String jsonCar = GSON.toJson(cars);
        setWritePath(jsonCar);
        printCarTable(cars);

        String jsonDriver = GSON.toJson(drivers);
        setWritePathDriver(jsonDriver);
        System.out.println();
        System.out.println("************************************************");
        printDriverTable(drivers);
//        System.out.println(jsonCar);
//        System.out.println("\n"+jsonDriver);



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

    public static void printCarTable(Car[] cars){
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
            for(int j = 0; j < tabsDriver; j++) {
                System.out.print(" ");
            }
            System.out.print("|  ");
            System.out.print(i.getState());
            for(int j = 0; j < tabsState - i.getState().toString().length(); j++) {
                System.out.print(" ");
            }
            counter++;
            System.out.println();
        }
    }

    public static void printDriverTable(Drivers[] drivers) {
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
            for (int j = 0; j < tabsBus; j++) {
                System.out.print(" ");
            }
            counter++;
            System.out.println();
        }
    }
}