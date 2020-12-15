package Figures;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;

    }

    public double calcArea() {
        return Math.PI * radius * radius;
    }
    public double calcPerimeter() {
        return 2.0 * Math.PI * radius;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Круг с радиусом " + radius + ", площадью " + calcArea() + " и периметром " + calcPerimeter());
        return str.toString();
    }
}
