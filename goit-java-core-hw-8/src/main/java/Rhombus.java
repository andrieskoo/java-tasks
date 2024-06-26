public class Rhombus extends Shape {
    private double side;
    private double angle;

    public Rhombus(double side, double angle) {
        this.side = side;
        this.angle = angle;
        this.name = "Rhombus";
    }
    public Rhombus(double side, double angle, String color) {
        this(side, angle);
        this.color = color;
    }


    public double getSide() {
        return side;
    }

    public double getAngle() {
        return angle;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    public void printParameters() {
        System.out.println(name + " with side=" + side + " and angle=" + angle + " and color " + color);
        System.out.println(name + " area is " + getArea());
    }

    @Override
    public double getArea() {
        return Math.pow(side, 2.0) * Math.sin(Math.toRadians(angle));
    }
}
