package agh.cs;

public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int hight) {
        super();
        this.width = width;
        this.height = hight;
    }

    @Override
    Vector2D getEdgeVector() {
        return new Vector2D(width, height);
    }

    @Override
    public Object objectAt(Vector2D position) {
        if(animalsMap.containsKey(position)) return animalsMap.get(position);
        return null;
    }
}
