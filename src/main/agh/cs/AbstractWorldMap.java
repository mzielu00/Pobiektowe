package agh.cs;

import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animalList;
    protected int width;
    protected int height;

    abstract Vector2D getEdgeVector();

    @Override
    public String toString() {
        return new MapVisualizer(this).draw(new Vector2D(0, 0), getEdgeVector());
    }

    @Override
    public boolean canMoveTo(Vector2D position) {
        return (position.x >= 0 && position.y >= 0 && position.x <= width && position.y <= height && !isOccupied(position));
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
    public boolean isOccupied(Vector2D position) {
        for (Animal i : animalList) {
            if (position.equals(i.getPosition())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        for (int i = 0; i <= directions.length; i++) {
            animalList.get(i).move(directions[i]);
        }
    }
}