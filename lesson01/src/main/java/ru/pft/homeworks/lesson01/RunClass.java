package ru.pft.homeworks.lesson01;

public class RunClass {

	public static void main (String[] args) {
		Point p1 = new Point(1, 7);
		Point p2 = new Point(2, 5);

		if(p1.x == p2.x && p1.y == p2.y) {	// проверяю, совпадают ли точки на плоскости. Если да - сразу пишу расстояние 0 без вычислений
			System.out.println("Координаты точек равны. Следовательно, точки совпадают друг с другом на плоскости.\nТаким образом, расстояние между ними равно 0.");
			return;
		}

		System.out.println("Расстояние между точками:\n");
		System.out.println("подсчитанное функцией distance = " + distance(p1, p2));
		System.out.println("подсчитанное методом distanceMethod класса Point: " + Point.distanceMethod(p1,p2));

	}

	public static double distance(Point p1, Point p2){
		return Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2) );
	}
}