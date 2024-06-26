public class Rectangle extends Shape {
    private int side1;
    private int side2;

    public Rectangle(int side1, int side2) {
        this.side1 = side1;
        this.side2 = side2;
        this.name = "Rectangle";
    }
    public Rectangle(int side1, int side2, String color) {
        this(side1, side2);
        this.color = color;
    }

    public int getSide1() {
        return side1;
    }

    public int getSide2() {
        return side2;
    }

    public void setSide1(int side1) {
        this.side1 = side1;
    }

    public void setSide2(int side2) {
        this.side2 = side2;
    }

    @Override
    public void printParameters() {
        System.out.println(name + " with side1=" + side1 + " and side2=" + side2 + " and color " + color);
        System.out.println(name + " area is " + getArea());
    }

    @Override
    public double getArea() {
        return side1 * side2;
    }
}
