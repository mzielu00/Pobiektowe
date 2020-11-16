package agh.cs;

import junit.framework.TestCase;
import org.junit.Test;

public class AbstractWorldMapTest extends TestCase {

    @Test
    public void testTestRun() {
        String [] tab = new String []{"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(tab);
        IWorldMap map = new GrassField(10);
        Vector2D[] positions = { new Vector2D(2,2), new Vector2D(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Vector2D anim1 = (((SimulationEngine)(engine)).animalslist.get(0).getPosition());
        Vector2D anim2 = (((SimulationEngine)(engine)).animalslist.get(1).getPosition());
        assertEquals("(3,0)", anim1.toString());
        assertEquals("(2,7)", anim2.toString());
    }
}