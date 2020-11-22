package agh.cs;

import junit.framework.TestCase;
import org.junit.Test;

public class GrassFieldTest extends TestCase {
    String [] tab = new String []{"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
    MoveDirection[] directions = new OptionsParser().parse(tab);
    IWorldMap map = new GrassField(10);
    Vector2D[] positions = { new Vector2D(2,2), new Vector2D(3,4) };
    IEngine engine = new SimulationEngine(directions, map, positions);
    @Test
    public void testGetEdgeVector() {
        //assertEquals("(9 ,9)",MapVisualizer(this).draw[1].toString());
    }
    @Test
    void canMoveToTest() {
        IWorldMap map = new GrassField(10);
        map.place(new Animal(map, new Vector2D(3,5)));
        map.place(new Animal(map, new Vector2D(3,8)));
        map.place(new Animal(map, new Vector2D(5,7)));

        assertFalse( map.canMoveTo(new Vector2D(3,5)));
        assertFalse( map.canMoveTo(new Vector2D(3,8)));
        assertFalse( map.canMoveTo(new Vector2D(5,7)));
        assertTrue( map.canMoveTo(new Vector2D(4,4)));
    }
    public void testObjectAt() {

    }
}