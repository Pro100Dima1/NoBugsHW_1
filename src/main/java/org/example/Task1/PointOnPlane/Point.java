package org.example.Task1.PointOnPlane;

public class Point implements Movable{
    private int x;
    private int y;

    public void setCoordinats(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getCoordinateX(){
        return this.x;
    }
    public int getCoordinateY(){
        return this.y;
    }

    @Override
    public void moveUp(int x, int y){
        System.out.println("X = " + x + "Y = " + y);
    }
    @Override
    public void moveDown(int x, int y){
        System.out.println("X = " + x + "Y = " + y);
    }
    @Override
    public void moveRight(int x, int y){
        System.out.println("X = " + x + "Y = " + y);
    }
    @Override
    public void moveLeft(int x, int y){
        System.out.println("X = " + x + "Y = " + y);

    }
}
