
package agh.cs;

public class World {
    public static void main(String[] args) {
//        Vector2D position1 = new Vector2D(1,2);
//        System.out.println(position1);
//        Vector2D position2 = new Vector2D(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));
//        MapDirection x = MapDirection.NORTH;
//        System.out.println(x.previous());
//        System.out.println(MapDirection.WEST.next());
//        System.out.println(position1.equals(position1));

        /*LAB 3:
        System.out.println("test move-a");
        Animal zwierz1 = new Animal();
        zwierz1.move(MoveDirection.RIGHT);
        zwierz1.move(MoveDirection.FORWARD);
        zwierz1.move(MoveDirection.FORWARD);
        zwierz1.move(MoveDirection.FORWARD);
        zwierz1.move(MoveDirection.BACKWARD);
        zwierz1.move(MoveDirection.BACKWARD);
        zwierz1.move(MoveDirection.LEFT);
        zwierz1.move(MoveDirection.FORWARD);
        System.out.println(zwierz1);

        System.out.println("test parser:");
        Animal zwierz2 = new Animal();
        String[] tab = {"f", "r", "left", "scds","sa", "r", "r", "b", "b", "l", "f"};

        MoveDirection[] arr = OptionsParser.parse(tab);
        for (MoveDirection i : arr) {
            System.out.println(i);
            zwierz2.move(i);
            System.out.println(zwierz2);
        }
         LAB 4:
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2D[] positions = { new Vector2D(2,2), new Vector2D(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }
        LAB5:
            */

        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        //IWorldMap map = new RectangularMap(10, 5);
        Vector2D[] positions = { new Vector2D(2,2), new Vector2D(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Vector2D anim1 = (engine.animalslist.get(0).getPosition());
        Vector2D anim2 = (engine.animalslist.get(1).getPosition());
        System.out.println(anim1.toString());
        System.out.println(anim2.toString());
    }
}
