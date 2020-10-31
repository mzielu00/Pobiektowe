package agh.cs.lab2;

public class Animal {
    static final int MIN_X = 0;
    static final int MAX_X = 4;
    static final int MIN_Y = 0;
    static final int MAX_Y = 4;


    private MapDirection orientacja = MapDirection.NORTH;
    private Vector2D polozenie = new Vector2D(2, 2);

    public String toString() {
        return (orientacja + ", (" + polozenie.x + ", " + polozenie.y + ")");
    }

    public void move(MoveDirection direction) {
        if (direction == MoveDirection.RIGHT) {
            orientacja = orientacja.next();
        }
        if (direction == MoveDirection.LEFT) {
            orientacja = orientacja.previous();
        }
        if (direction == MoveDirection.FORWARD) {
            if (polozenie.x == MIN_X && orientacja == MapDirection.WEST || polozenie.y == MIN_Y && orientacja == MapDirection.SOUTH || polozenie.x == MAX_X && orientacja == MapDirection.EAST || polozenie.y == MAX_Y && orientacja == MapDirection.NORTH) {
                polozenie = polozenie;
            } else {
                polozenie = orientacja.toUnitVector().add(polozenie);
            }
        }
        if (direction == MoveDirection.BACKWARD) {
            if (polozenie.x == MIN_X && orientacja == MapDirection.EAST || polozenie.y == MIN_Y && orientacja == MapDirection.NORTH || polozenie.x == MAX_X && orientacja == MapDirection.WEST || polozenie.y == MAX_Y && orientacja == MapDirection.SOUTH) {
                polozenie = polozenie;
            } else {
                polozenie = orientacja.toUnitVector().opposite().add(polozenie);
            }
        }
    }
}
