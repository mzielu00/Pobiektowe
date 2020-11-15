package agh.cs;

import junit.framework.TestCase;
import org.junit.Test;

public class RectangularMapTest extends TestCase {

    @Test
    public void testObjectAt() {
        IWorldMap map = new GrassField(12);
        map.place(new Animal(map, new Vector2D(2,3)));
        map.place(new Animal(map, new Vector2D(5,0)));
        map.place(new Animal(map, new Vector2D(6,2)));
        map.place(new Animal(map, new Vector2D(5,0)));

        assertTrue( null != map.objectAt(new Vector2D(6,2)));
        assertTrue( null != map.objectAt(new Vector2D(2,3)));
    }
}