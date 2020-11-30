package agh.cs;

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;


public class MapBoundary implements IPositionChangeObserver {
    private final SortedSet<Vector2D> xSet;
    private final SortedSet<Vector2D> ySet;

    public MapBoundary() {
        xSet = new TreeSet<>((e1, e2) -> {
            if (e1.getX() != e2.getX())
                return Integer.compare(e1.getX(), e2.getX());
            else if (e1.getY() != e2.getY())
                return Integer.compare(e1.getY(), e2.getY());
            else
                return 0;
        });
        ySet = new TreeSet<>((e1, e2) -> {
            if (e1.getY() != e2.getY())
                return Integer.compare(e1.getY(), e2.getY());
            else if (e1.getX() != e2.getX())
                return Integer.compare(e1.getX(), e2.getX());
            else
                return 0;
        });
    }

    public void addElement(Vector2D element) {
        xSet.add(element);
        ySet.add(element);
    }
    public void removeElement(Vector2D element) {
        xSet.remove(element);
        ySet.remove(element);
    }


    @Override
    public void positionChanged(IMapElement element, Vector2D oldPosition, Vector2D newPosition) {
        removeElement(oldPosition);
        addElement(newPosition);
    }

    public Vector2D[] getBoundary() {
        return new Vector2D[]{new Vector2D(xSet.first().getX(), ySet.first().getY()),
                new Vector2D(xSet.last().getX(), ySet.last().getY()) };
    }

    public void addElement(Grass grass) {
        xSet.remove(grass);
        ySet.remove(grass);
    }
}