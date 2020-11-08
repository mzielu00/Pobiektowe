package agh.cs;

import junit.framework.TestCase;
import org.junit.Test;

public class SimulationEngineTest extends TestCase {

    @Test
    public void testTestRun1() {
        String[] tab = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(tab);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2D[] positions = { new Vector2D(2,2), new Vector2D(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Vector2D anim1 = (((SimulationEngine)(engine)).animalslist.get(0).getPosition());
        Vector2D anim2 = (((SimulationEngine)(engine)).animalslist.get(1).getPosition());
        assertEquals("(3,0)",anim1.toString());
        assertEquals("(2,5)",anim2.toString());
    }

    @Test
    public void testTestRun2() {
        String[] tab = {"f", "f", "b", "f", "l", "l", "r", "b", "f", "f", "b", "f", "l", "r", "l"};
        MoveDirection[] directions = new OptionsParser().parse(tab);
        IWorldMap map = new RectangularMap(3, 7);
        Vector2D[] positions = { new Vector2D(0,0), new Vector2D(2,2), new Vector2D(1,6)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Vector2D anim1 = (((SimulationEngine)(engine)).animalslist.get(0).getPosition());
        Vector2D anim2 = (((SimulationEngine)(engine)).animalslist.get(1).getPosition());
        Vector2D anim3 = (((SimulationEngine)(engine)).animalslist.get(2).getPosition());
        assertEquals("(1,2)",anim1.toString());
        assertEquals("(3,3)",anim2.toString());
        assertEquals("(0,5)", anim3.toString());
    }
}