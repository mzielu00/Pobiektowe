package agh.cs;

import java.util.LinkedList;
import java.util.List;

public class SimulationEngine implements IEngine {
    public MoveDirection[] directions;
    public Vector2D[] positions;
    public IWorldMap map;
    public List<Animal> animalslist;
    public MapDirection orientacions;


    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2D[] positions) {
        this.directions = directions;
        this.positions = positions;
        this.map = map;
        this.animalslist = new LinkedList<>();
        this.orientacions = MapDirection.NORTH;

        for (Vector2D vector : positions) {
            animalslist.add(new Animal(map, vector));
            map.place(new Animal(map, vector));
        }
    }

    @Override
    public void run() {
        map.run(directions);
    }
}


