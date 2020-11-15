package agh.cs;

public class Grass implements IMapElement{
    public Vector2D position;

    public Grass(Vector2D position) {
        this.position = position;
    }

    @Override
    public Vector2D getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "*";
    }
}