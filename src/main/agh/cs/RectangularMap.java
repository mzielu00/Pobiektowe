package agh.cs;

import java.util.LinkedList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    public int width;
    public int hight;
    public List<Animal> list;

    public RectangularMap(int width, int hight) {
        this.width = width;
        this.hight = hight;
        this.list = new LinkedList<Animal>();
    }
    @Override
    public String toString() {
        return new MapVisualizer(this).draw(new Vector2D(0, 0), new Vector2D(width, hight));
    }

    @Override
    public boolean canMoveTo(Vector2D position) {
        return (position.x >= 0 && position.y >= 0 && position.x <= width && position.y <= hight && !isOccupied(position));
        }

    @Override
    public boolean isOccupied (Vector2D position){
        for (Animal i : list) {
            if (position.equals(i.position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if(!isOccupied(animal.position)) {
            list.add(animal);
            return true;
        }
        else {

        return false;
        }
    }

    @Override
    public Object objectAt(Vector2D position) {
        for(Animal i: list) {
            if(position.equals(i.position)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void run(MoveDirection[] directions) {
        for(int i = 0; i <= directions.length; i++){
            list.get(i).move(directions[i]);
        }
    }
    public int getNumAnimals(){
        return this.list.size();
    }
    public Animal getAnimal(int Idx) {
        return this.list.get(Idx);
    }
}

