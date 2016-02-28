package ru.pft.homeworks.lesson01;


import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

    @Test
    public void testDistanceAllPositiveNum() {  //Тест со всеми положительными координатами
        Point p1 = new Point(1,5);
        Point p2 = new Point (2, 4);
        Assert.assertEquals(Point.distanceMethod(p1,p2), 1.4142135623730951);
    }

    @Test
    public void testDistanceAllNegativeNum() {  //Тест со всеми отрицательными координатами
        Point p1 = new Point(-1,-5);
        Point p2 = new Point (-2, -4);
        Assert.assertEquals(Point.distanceMethod(p1,p2), 1.4142135623730951);
    }

    @Test
    public void testDistanceFirstZeroCoordinates() {    //Тест для случая, когда первая точка лежит в (0; 0)
        Point p1 = new Point(0,0);
        Point p2 = new Point (-2, -4);
        Assert.assertEquals(Point.distanceMethod(p1,p2), 4.47213595499958);
    }

    @Test
    public void testDistanceEqualPoints() { //Тест для случая, когда точки совпадают
        Point p1 = new Point(2,-5);
        Point p2 = new Point (2, -5);
        Assert.assertEquals(Point.distanceMethod(p1,p2), 0.0);
    }


}
