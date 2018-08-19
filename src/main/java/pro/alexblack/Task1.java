package pro.alexblack;

import pro.alexblack.geometry.Point;
import pro.alexblack.geometry.Rect;

/*
 Написать программу, которая принимает 2 точки прямоугольника (диагональ) и возвращает его площадь (возвращаемый тип: double).
*/

public class Task1 {

    public static void main(String[] args) {
        Point point1 = new Point(-100, 100);
        Point point2 = new Point(100, -100);

        Rect rect = new Rect(point1, point2);
        System.out.println("Rectangle area with points: (" + point1 + ") and (" + point2 + ") is " + rect.getArea());
    }
}