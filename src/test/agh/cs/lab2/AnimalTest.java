package agh.cs.lab2;

import junit.framework.TestCase;
import org.junit.Test;

public class AnimalTest extends TestCase {
    Animal animal1 = new Animal();
    Animal animal2 = new Animal();
    Animal animal3 = new Animal();
    MoveDirection[] mapa1 = {MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.BACKWARD};
    MoveDirection[] mapa2 = {MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD};
    MoveDirection[] mapa3 = {MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD,MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD,MoveDirection.LEFT};

    @Test
    public void testMove1() {
        for(MoveDirection i: mapa1){
            animal1.move(i);
        }
        assertEquals("Północ, (4, 2)", animal1.toString());
    }

    @Test
    public void testMove2() {
        for(MoveDirection i: mapa2){
            animal2.move(i);
        }
        assertEquals("Zachód, (0, 1)", animal2.toString());
    }

    @Test
    public void testMove3() {
        for(MoveDirection i: mapa3){
            animal3.move(i);
        }
        assertEquals("Południe, (0, 0)", animal3.toString());
    }

}