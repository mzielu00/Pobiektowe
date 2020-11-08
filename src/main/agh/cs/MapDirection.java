
package agh.cs;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

    public String toString() {
        switch (this) {
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            case WEST:
                return "Zachód";
            case EAST:
                return "Wschód";
        }
        return null;
    }
    public MapDirection next(){
        switch (this) {
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            case NORTH:
                return EAST;
        }
        return null;
    }
    public MapDirection previous(){
        switch (this) {
            case EAST:
                return NORTH;
            case SOUTH:
                return EAST;
            case WEST:
                return SOUTH;
            case NORTH:
                return WEST;
        }
        return null;
    }
    public Vector2D toUnitVector(){
        switch (this){
            case EAST:
                return new Vector2D(1,0);
            case WEST:
                return new Vector2D(-1,0);
            case NORTH:
                return new Vector2D(0,1);
            case SOUTH:
                return new Vector2D(0,-1);
        }
        return null;
    }
}