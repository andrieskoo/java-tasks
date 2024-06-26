public class PngPrinter implements EditorPrinter{
    @Override
    public void print(Editor editor) {
        System.out.println("Start print to PNG file");
        System.out.println();

        for (GraphicObject graphicObject: editor.getAllGraphics()){
            if (graphicObject == null){
                break;
            }
            graphicObject.printParameters();
            System.out.println();

        }
        System.out.println("End print to PNG");
    }
}