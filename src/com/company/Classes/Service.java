package com.company.Classes;

import com.company.Interface.Services;

import java.util.Random;

import static com.company.enums.CarState.*;

public class Service implements Services {

    @Override
    public void changeDriver(Drivers drivers, Car car) {
        if(car.getCarState().equals(BASE)){
            car.setDriver(drivers.getName());
            drivers.setBus(car.getName());
            System.out.println("The truck " + car.getName() + "'s driver is: " + drivers.getName());
        }
        if (car.getCarState().equals(ROUTE)) {
            throw new ChangeDriverException("The driver on the road. You can't change this driver");
        }
        if (car.getCarState().equals(REPAIR)){
                throw new ChangeDriverException("The truck in repair. You can't change the driver");
            }
        }


    @Override
    public void startDriving(Drivers drivers, Car cars) {
    if(cars.getCarState().equals(BASE) && cars.getDriver() != null){
        cars.setCarState(ROUTE);
        cars.setDriver(drivers.getName());
        System.out.println("The truck is successfully on the road");
    } else if(cars.getCarState().equals(ROUTE)){
        throw new CarStateException("The truck is already on the road");
    } else if (cars.getCarState().equals(REPAIR)) {
        Random random = new Random();
        int a = random.nextInt(1, 3);
        if (a == 1)
            cars.setCarState(ROUTE);
        else
            cars.setCarState(BASE);
        System.out.println("The trucks state is: " + cars.getCarState());
    }


    }

    @Override
    public void startRepair(Drivers drivers, Car cars) {
        if (cars.getCarState().equals(BASE) || cars.getCarState().equals(ROUTE)){
            cars.setCarState(REPAIR);
            System.out.println("The truck is in repair");
        }
        else if (cars.getCarState().equals(REPAIR)) {
            throw new CarStateException("The truck is already in repair");

        }

    }
}
