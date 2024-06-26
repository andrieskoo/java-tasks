import java.security.SecureRandom;

public class Quad extends Shape {
    private int side;

    public Quad(int side) {
        this.side = side;
        this.name = "Quad";
    }
    public Quad(int side, String color) {
        this(side);
        this.color = color;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public void printParameters() {
        System.out.println(name + " with side=" + side + " and color " + color);
        System.out.println(name + " area is " + getArea());
    }

    @Override
    public double getArea() {
        return side * side;
    }
}
