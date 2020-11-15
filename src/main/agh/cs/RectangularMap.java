package agh.cs;

import java.util.LinkedList;

public class RectangularMap extends AbstractWorldMap {
    public RectangularMap(int width, int hight) {
        this.width = width;
        this.height = hight;
        this.animalList = new LinkedList<Animal>();
    }

    @Override
    Vector2D getEdgeVector() {
        return new Vector2D(width, height);
    }

    @Override
    public boolean place(Animal animal) {
        if (!isOccupied(animal.getPosition())) {
            animalList.add(animal);
            return true;
        } else {

            return false;
        }
    }

    @Override
    public Object objectAt(Vector2D position) {
        for (Animal i : animalList) {
            if (position.equals(i.getPosition())) {
                return i;
            }
        }
        return null;
    }
}
