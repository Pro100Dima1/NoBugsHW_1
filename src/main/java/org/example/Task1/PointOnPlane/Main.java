package org.example.Task1.PointOnPlane;

public class Main {
    public static void main(String[] args){
        Point point = new Point();
        point.setCoordinats(3,4);
        point.moveUp(3,0);
        point.moveDown(0, -2);
        point.moveLeft(-1, 1);
        point.moveRight(1,0);
    }
}
