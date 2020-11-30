package agh.cs;

public interface IPositionChangeObserver {

    void positionChanged(IMapElement element, Vector2D oldPosition, Vector2D newPosition);
}
