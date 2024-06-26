public class Editor {

    private GraphicObject[] graphicObjectsArr = new GraphicObject[128];
    private byte lastIndex = 0;


    public void addGraphicObject(GraphicObject go) {
        graphicObjectsArr[lastIndex] = go;
        lastIndex++;
    }

    public GraphicObject[] getAllGraphics() {
        return this.graphicObjectsArr;
    }
}
