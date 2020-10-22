
package agh.cs.lab2;

public class World {
    public static void main(String[] args) {
        Vector2D position1 = new Vector2D(1,2);
        System.out.println(position1);
        Vector2D position2 = new Vector2D(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection x = MapDirection.NORTH;
        System.out.println(x.previous());
        System.out.println(MapDirection.WEST.next());
        System.out.println(position1.equals(position1));
    }
}
