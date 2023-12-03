package emilio;

public class Point {
    public int x;
    public int y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point add(int dx, int dy) {
        return new Point( x + dx, y + dy );
    }
    public Point add( Point p) {
        return add( p.x, p.y );
    }

    public boolean equals(Object obj) {
        return (obj instanceof Point) && (x == ((Point)obj).x) && ( y == ((Point)obj).y);
    }

    public String toString() {
        return getClass().getName() + "[x=" + x + ",y=" + y + "]";
    }
}