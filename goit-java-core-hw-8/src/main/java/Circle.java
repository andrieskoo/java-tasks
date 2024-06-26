public class Circle extends Shape {
    private double radius;

    public Circle(double radius, String color) {
        this(radius);
        this.color = color;
    }

    public Circle(double radius) {
        this.name = "Circle";
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    public double getArea() {
        return Math.PI*Math.pow(this.radius, 2.0);
    }

    @Override
    public void printParameters() {
        System.out.println(name + " with radius=" + radius + " and color " + color);
        System.out.println(name + " area is " + getArea());
    }
}
