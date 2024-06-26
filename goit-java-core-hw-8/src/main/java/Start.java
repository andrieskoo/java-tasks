import javax.sql.RowSetMetaData;

public class Start {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.addGraphicObject(new Circle(2.0));
        editor.addGraphicObject(new Line(5));
        editor.addGraphicObject(new Triangle(5, 4));
        editor.addGraphicObject(new Quad(5));
        editor.addGraphicObject(new Rectangle(5, 4));
        editor.addGraphicObject(new Rhombus(5, 30, "#458323"));

        EditorPrinter editorPdfPrinter = new PdfPrinter();
        editorPdfPrinter.print(editor);


    }
}
