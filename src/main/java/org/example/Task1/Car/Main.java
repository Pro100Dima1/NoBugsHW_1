package org.example.Task1.Car;

public class Main {
    public static void main(String[] args){
        Car car = new Car();
        car.setInfoCar("BMW", "E100", 1997);
        car.setSpeedCar(0,500);
        car.start();
        car.stop();
        System.out.println("Пройденная дистанция = " + car.drive() + " км");
    }
}
