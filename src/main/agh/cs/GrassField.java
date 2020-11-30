package agh.cs;

import java.util.*;

public class GrassField extends AbstractWorldMap {
    public int numberOfGrassOnMap;
    private final List<Grass> grassList;

    public GrassField(int numberOfGrassOnMap) {
        super();
        width = Integer.MAX_VALUE;
        height = Integer.MAX_VALUE;
        this.numberOfGrassOnMap = numberOfGrassOnMap;
        this.grassList = new LinkedList<>();

        addGrasses(numberOfGrassOnMap);
    }

    @Override
    Vector2D getEdgeVector() {
        return new Vector2D(getFarthestWidth(), getFarthestHeight());
    }

    @Override
    public Object objectAt(Vector2D position) {

        if (animalsMap.containsKey(position)) {
            return animalsMap.get(position);
        } else {
            for (Grass element : grassList) {
                if (position.equals(element.getPosition())) {
                    return element;
                }
            }

            return null;
        }
    }

    private int getFarthestWidth() {
        List<IMapElement> mergedList = new LinkedList<>();
        mergedList.addAll(grassList);
        mergedList.addAll(animalsMap.values());

        int currentFarthest = 0;

        for (IMapElement element : mergedList) {
            if (element.getPosition().x > currentFarthest) {
                currentFarthest = element.getPosition().x;
            }
        }

        return currentFarthest;
    }

    private int getFarthestHeight() {
        List<IMapElement> mergedList = new LinkedList<>();
        mergedList.addAll(grassList);
        mergedList.addAll(animalsMap.values());

        int currentFarthest = 0;

        for (IMapElement element : mergedList) {
            if (element.getPosition().y > currentFarthest) {
                currentFarthest = element.getPosition().y;
            }
        }

        return currentFarthest;
    }

    private void addGrasses(int numberOfGrassOnMap) {
        Random random = new Random();
        int edgeValue = (int) Math.sqrt(numberOfGrassOnMap * 10);
        int currentCounter = 0;

        do {
            int randomX = random.nextInt(edgeValue);
            int randomY = random.nextInt(edgeValue);

            Vector2D newPosition = new Vector2D(randomX, randomY);

            if (objectAt(newPosition) == null) {
                grassList.add(new Grass(newPosition));
                currentCounter++;
                mapBoundary.addElement(new Grass(newPosition));
            }

        } while (currentCounter < numberOfGrassOnMap);
    }
}