package org.example.Task1.Car;

public class Car implements Drivable {
    private String mark;
    private String model;
    private int yearOfRelease;
    private int start;
    private int stop;

    public void setInfoCar(String mark, String model, int yearOfRelease){
        this.mark = mark;
        this.model = model;
        this.yearOfRelease = yearOfRelease;
    }
    public void setSpeedCar(int start, int stop){
        this.start = start;
        this.stop = stop;
    }
    public String getMark(){
        return mark;
    }
    public String getModel(){
        return model;
    }
    public int getYearOfRelease(){
        return yearOfRelease;
    }

    @Override
    public void start() {
        System.out.println("Машина марки " + mark + " начинает путь с " + start + " км");
    }

    @Override
    public void stop() {
        System.out.println("Машина марки " + mark + " заканчивае путь на " + stop + " км");
    }

    @Override
    public int drive() {
        int distance = stop - start;
        return distance;
    }
}
