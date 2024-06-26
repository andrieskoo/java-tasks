public class PdfPrinter implements EditorPrinter{
    @Override
    public void print(Editor editor) {
        System.out.println("Start print to PDF file");
        System.out.println();

        for (GraphicObject graphicObject: editor.getAllGraphics()){
            if (graphicObject == null){
                break;
            }
            graphicObject.printParameters();
            System.out.println();
        }
        System.out.println("End print to pdf");
    }
}
