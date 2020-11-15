package agh.cs;

public class Animal implements IMapElement{
    static final int MIN_X = 0;
    static final int MAX_X = 4;
    static final int MIN_Y = 0;
    static final int MAX_Y = 4;

    public IWorldMap map;
    public Vector2D initialPosition;
    public MapDirection orientation;
    private Vector2D position;

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
        if (direction == MoveDirection.RIGHT) {
            orientation = orientation.next();
        }
        if (direction == MoveDirection.LEFT) {
            orientation = orientation.previous();
        }
        if (direction == MoveDirection.FORWARD) {
            if (map.canMoveTo(orientation.toUnitVector().add(position))) {
                position = orientation.toUnitVector().add(position);
            }
        }
        if (direction == MoveDirection.BACKWARD) {
            if (map.canMoveTo(orientation.toUnitVector().opposite().add(position))) {
                position = orientation.toUnitVector().opposite().add(position);
            }
        }
        /*System.out.println(getPosition());
        System.out.println(toString());*/
    }

}