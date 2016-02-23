package ru.pft.homeworks.lesson01;

public class Point {
    public double x;
    public double y;

    public Point(double x, double y){   //Конструктор
        this.x = x;
        this.y = y;
    }

    static double distanceMethod(Point a, Point b) {    //Метод рассчета расстояния между двумя точками
        return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2) );
    }
}
