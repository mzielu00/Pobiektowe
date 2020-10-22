package agh.cs.lab2;

public class Vector2D {
    public final int x;
    public final int y;
    public Vector2D(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "(" + x + "," + y + ")";
    }
    public boolean precedes(Vector2D other){
        return (other.x >= this.x && other.y >= this.y);
    }
    public boolean follows(Vector2D other){
        return (other.x <= this.x && other.y <= this.y);
    }
    Vector2D upperRight(Vector2D other){
        int maxx = Math.max(other.x, this.x);
        int maxy = Math.max(other.y, this.y);
        return new Vector2D(maxx, maxy);
    }
    Vector2D lowerLeft(Vector2D other){
        int minx = Math.min(other.x, this.x);
        int miny = Math.min(other.y, this.y);
        return new Vector2D(minx, miny);
    }
    Vector2D add(Vector2D other){
        return new Vector2D(other.x + this.x, other.y + this.y);
    }
    Vector2D subtract(Vector2D other){
        return new Vector2D(other.x - this.x, other.y - this.y);
    }
    public boolean equals(Object other){
        Vector2D otherVec = (Vector2D) other;
        if (other == this){
            return true;
        }
        else if (!(other instanceof Vector2D)) {
            return false;
        }
        return(this.x == otherVec.x && this.y == otherVec.y);
    }
    Vector2D opposite(){
        return new Vector2D(-this.x,-this.y);
    }
}