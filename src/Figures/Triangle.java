package Figures;

public class Triangle implements Shape{
    private double side1, side2, side3;

    public Triangle(double side1, double side2, double side3)  {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;


    }
    public double calcArea() {
        final double p = (side1 + side2 + side3)/ 2.0;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    public double calcPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Треугольник со сторонами " + side1 + ", " + side2 + " и " + side3 + ", площадью " + calcArea() + "и периметром " + calcPerimeter());
        return str.toString();
    }
}
