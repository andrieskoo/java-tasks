public class Line extends GraphicObject {

    private LineType lineType;
    private int length;

    public Line(int length) {
        this(LineType.SOLID, length);
    }

    public Line(LineType lineType, int length) {
        this.lineType = lineType;
        this.length = length;
        this.name = "Line";
    }

    public LineType getLineType() {
        return lineType;
    }

    public int getLength() {
        return length;
    }

    public void setLineType(LineType lineType) {
        this.lineType = lineType;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void printParameters() {
        System.out.println(name + " type of " + lineType +" with length=" + length + " and color " + color);
    }


}
