import java.lang.Math;

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }
}

class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getx() - p2.getx(), 2) + Math.pow(p1.gety() - p2.gety(), 2));
    }

    public double getPerimeterFloat() {
        double ab = distance(a, b);
        double bc = distance(b, c);
        double ca = distance(c, a);
        double perimeter = ab + bc + ca;

        return perimeter;
    }

    public int getPerimeter() {
        return (int) Math.floor(getPerimeterFloat());
    }

    public double getAreaFloat() {
        double ab = distance(a, b);
        double bc = distance(b, c);
        double ca = distance(c, a);
        double half_peri = getPerimeterFloat() / 2;
        double area = Math.sqrt(half_peri * (half_peri - ab) * (half_peri - bc) * (half_peri - ca));

        return area;
    }

    public int getArea() {
        return (int) Math.floor(getAreaFloat());
    }

    public String toString() {
        String string = "Triangle: A(" + a.getx() + ", " + a.gety() + "), B(" + b.getx() + ", " + b.gety() + "), C(" + c.getx() + ", " + c.gety() + ")";
        return string;
    }
}

public class Main {
    public static void main(String[] args) {
        Point a = new Point(1, 1);
        Point b = new Point(1, 2);
        Point c = new Point(2, 1);
        Triangle x = new Triangle(a, b, c);

        System.out.println(x.toString());
        System.out.println(x.getPerimeterFloat() + " " + x.getPerimeter());
        System.out.println(x.getAreaFloat() + " " + x.getArea());
    }
}
