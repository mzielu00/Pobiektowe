package agh.cs;

public interface IPositionChangeObserver {

    void positionChanged(Vector2D oldPosition, Vector2D newPosition);
}
