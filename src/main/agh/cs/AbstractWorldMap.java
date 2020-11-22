package agh.cs;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2D, Animal> animalsMap;

    protected int width;
    protected int height;

    abstract Vector2D getEdgeVector();

    public AbstractWorldMap() {
        this.animalsMap = new LinkedHashMap<>();

    }

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
            animalsMap.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isOccupied(Vector2D position) {
        return objectAt(position) != null;
    }

    @Override
    public void run(MoveDirection[] directions) {
        List<Animal> animals = new ArrayList<>(animalsMap.values());
        for (int i = 0; i < directions.length; i++) {
            animals.get(i % animals.size()).move(directions[i]);

            System.out.println("Step " + i);
            for (Animal animal : animals) {
                System.out.println("Animal " + animals.indexOf(animal) + " position: " + animal.getPosition());
            }
        }
    }

    @Override
    public void positionChanged(Vector2D oldPosition, Vector2D newPosition) {
        Object object = objectAt(oldPosition);

        if (object instanceof Animal) {
            animalsMap.remove(oldPosition);
            animalsMap.put(newPosition, (Animal) object);
        }
    }
}