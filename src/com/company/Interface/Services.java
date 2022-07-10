package com.company.Interface;

import com.company.Classes.Car;
import com.company.Classes.Drivers;

public interface Services {
    void changeDriver(Drivers drivers, Car cars);
    void startDriving(Drivers drivers, Car cars);
    void startRepair(Drivers drivers, Car cars);

}
