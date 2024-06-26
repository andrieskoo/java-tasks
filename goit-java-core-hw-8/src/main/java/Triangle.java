public class Triangle extends Shape {
    private int high;

    private int side;

    public Triangle(int high, int side) {
        this.high = high;
        this.side = side;
        this.name = "Triangle";
    }
    public Triangle(int high, int side, String color) {
        this(high, side);
        this.color = color;
    }

    @Override
    public void printParameters() {
        System.out.println(name + " with high=" + high + " and side=" + side +" and color is " + color);
        System.out.println(name + " area is " + getArea());
    }

    @Override
    public double getArea() {
        return 0.5 * side*high;
    }
}
