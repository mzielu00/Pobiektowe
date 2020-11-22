package agh.cs;

import java.util.LinkedList;
import java.util.List;

public class Animal implements IMapElement{
    static final int MIN_X = 0;
    static final int MAX_X = 4;
    static final int MIN_Y = 0;
    static final int MAX_Y = 4;

    public IWorldMap map;
    public Vector2D initialPosition;
    public MapDirection orientation;
    private Vector2D position;

    private List<IPositionChangeObserver> observers = new LinkedList<>();

    public Animal (){
        this.map = new RectangularMap(5, 10);
        this.initialPosition = new Vector2D(2,2);
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
    }

    public Animal (IWorldMap map){
        this.map = map;
        this.initialPosition = new Vector2D(2,2);
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
    }
    public Animal (IWorldMap map, Vector2D initialPosition) {
        this.map = map;
        this.initialPosition = initialPosition;
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
    }

    @Override
    public Vector2D getPosition() {
        return position;
    }

    public String toString() {
        switch(orientation){
            case NORTH: return "N";
            case SOUTH: return "S";
            case EAST: return "E";
            case WEST: return "W";
        }
        return null;
    }

    public void move(MoveDirection direction) {
        Vector2D oldPosition = position;

        if (direction == MoveDirection.RIGHT) {
            orientation = orientation.next();
        }
        if (direction == MoveDirection.LEFT) {
            orientation = orientation.previous();
        }
        if (direction == MoveDirection.FORWARD) {
            if (map.canMoveTo(orientation.toUnitVector().add(position))) {
                position = orientation.toUnitVector().add(position);

                positionChanged(oldPosition, position);
            }
        }
        if (direction == MoveDirection.BACKWARD) {
            if (map.canMoveTo(orientation.toUnitVector().opposite().add(position))) {
                position = orientation.toUnitVector().opposite().add(position);

                positionChanged(oldPosition, position);
            }
        }
    }

    void addObserver(IPositionChangeObserver observer) {
        observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        int indexOfGivenObserver = observers.indexOf(observer);

        if (indexOfGivenObserver >= 0 && indexOfGivenObserver < observers.size()) {
            observers.remove(indexOfGivenObserver);
        }
    }

    void positionChanged(Vector2D oldPosition, Vector2D newPosition) {
        for (IPositionChangeObserver element : observers) {
            element.positionChanged(oldPosition, newPosition);
        }
    }
}