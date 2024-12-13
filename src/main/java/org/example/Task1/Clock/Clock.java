package org.example.Task1.Clock;

public class Clock implements Readable{
    private int sec;
    private int min;
    private int hours;

    public void setTime(int sec, int min, int hours){
        this.sec = sec;
        this.min = min;
        this.hours = hours;
    }
    public int getMinutes(){
        return this.min;
    }
    public int getSeconds(){
        return this.sec;
    }
    public int getHours(){
        return this.hours;
    }
    public int tick(){
        sec+=1;
        return sec;
    }

    @Override
    public void readTime(){
        System.out.println("Текущее время: " + hours + " : " + min + " : " + tick());
    }
}
