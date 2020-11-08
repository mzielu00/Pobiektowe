package agh.cs;

import junit.framework.TestCase;
import org.junit.Test;

public class Vector2DTest extends TestCase {

    @Test
    public void testTestToString() {
        Vector2D wektor = new Vector2D (1,2);
        assertEquals("(1,2)", wektor.toString());
    }
    @Test
    public void testPrecedes() {
        Vector2D wektor1 = new Vector2D (2,3);
        Vector2D wektor2 = new Vector2D (4,7);
        Vector2D wektor3 = new Vector2D (4,6);
        assertTrue(wektor1.precedes(wektor2));
        assertFalse(wektor2.precedes(wektor3));
        assertFalse(wektor3.precedes(wektor1));
        assertTrue(wektor3.precedes(wektor2));
    }
    @Test
    public void testFollows() {
        Vector2D wektor1 = new Vector2D (2,3);
        Vector2D wektor2 = new Vector2D (4,7);
        Vector2D wektor3 = new Vector2D (4,6);
        assertFalse(wektor1.follows(wektor2));
        assertTrue(wektor2.follows(wektor3));
        assertTrue(wektor3.follows(wektor1));
        assertFalse(wektor3.follows(wektor2));
    }
    @Test
    public void testUpperRight() {
        Vector2D wektor1 = new Vector2D (7,8);
        Vector2D wektor2 = new Vector2D (4,7);
        Vector2D wektor3 = new Vector2D (9,6);
        Vector2D wektor4 = new Vector2D(9,8);
        assertEquals(wektor4, wektor3.upperRight(wektor1));
        assertEquals(wektor1, wektor2.upperRight(wektor1));
        assertEquals(wektor1, wektor1.upperRight(wektor2));
        assertEquals(wektor4, wektor1.upperRight(wektor3));
    }
    @Test
    public void testLowerLeft() {
        Vector2D wektor1 = new Vector2D (7,8);
        Vector2D wektor2 = new Vector2D (4,7);
        Vector2D wektor3 = new Vector2D (9,6);
        Vector2D wektor4 = new Vector2D(4,6);
        assertEquals(wektor4, wektor2.lowerLeft(wektor3));
        assertEquals(wektor2, wektor1.lowerLeft(wektor2));
        assertEquals(wektor2, wektor2.lowerLeft(wektor1));
        assertEquals(wektor4, wektor3.lowerLeft(wektor2));
    }
    @Test
    public void testAdd() {
        Vector2D wektor1 = new Vector2D (7,8);
        Vector2D wektor2 = new Vector2D (4,7);
        Vector2D wektor3 = new Vector2D (11,15);
        assertEquals(wektor3, wektor2.add(wektor1));
    }
    @Test
    public void testSubtract() {
        Vector2D wektor1 = new Vector2D (7,8);
        Vector2D wektor2 = new Vector2D (4,7);
        Vector2D wektor3 = new Vector2D (-3,-1);
        assertEquals(wektor3,wektor1.subtract(wektor2));
    }
    @Test
    public void testTestEquals() {
        Vector2D wektor1 = new Vector2D (7,8);
        Vector2D wektor2 = new Vector2D (4,7);
        Vector2D wektor3 = new Vector2D (7,8);
        assertTrue(wektor1.equals(wektor3));
        assertFalse(wektor2.equals(wektor3));
    }
    @Test
    public void testOpposite() {
        Vector2D wektor1 = new Vector2D (7,8);
        Vector2D wektor2 = new Vector2D (-7,-8);
        assertEquals(wektor2, wektor1.opposite());
    }
}