package pro.alexblack.geometry;

import pro.alexblack.geometry.Point;
import pro.alexblack.geometry.Rect;

/*
 Написать программу, которая принимает 2 прямоугольника (каждый строится из 2 точек) и возвращает площадь области их
 пересечения.
*/

public class Task2 {

    public static void main(String[] args) {
        Rect rect1 = new Rect(new Point(0, 0), new Point(10, 10));
        Rect rect2 = new Rect(new Point(5, 5), new Point(15, 15));

        System.out.println("Intersection area is: " + rect1.getIntersectionArea(rect2));
    }
}
