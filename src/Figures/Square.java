package Figures;

public class Square implements Shape{
    private double side;

    public Square (double side)  {
        this.side =  side;

    }

    public double calcArea() {
        return side * side;
    }

    public double calcPerimeter() {
        return 4*side;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Квадрат со стороной " + side + " ,площадью " + calcArea() + " и периметром " + calcPerimeter());
        return str.toString();
    }
}
