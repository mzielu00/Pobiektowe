package agh.cs;

import junit.framework.TestCase;
import org.junit.Test;

public class OptionsParserTest extends TestCase {

    @Test
    public void testParse1() {
        Animal animal1 = new Animal();
        String[] tab1 = {"f", "r", "forward", "scds", "r", "b","backward", "b", "l", "f"};
        MoveDirection[] tablica1 = OptionsParser.parse(tab1);
        for (MoveDirection i: tablica1){
            animal1.move(i);
        }
        assertEquals("Wschód, (4, 4)", animal1.toString());
    }

    @Test
    public void testParse2() {
        Animal animal2 = new Animal();
        String[] tab2 = {"b", "r", "backward", "scds", "l", "b","backward", "r", "f", "l", "left"};
        MoveDirection[] tablica2 = OptionsParser.parse(tab2);
        for (MoveDirection i: tablica2){
            animal2.move(i);
        }
        assertEquals("Zachód, (2, 0)", animal2.toString());
    }
}