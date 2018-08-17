package pro.alexblack.geometry;

public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Point)) {
            return false;
        }

        Point pt = (Point) obj;
        return x == pt.x && y == pt.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;

        return result;
    }

    @Override
    public String toString() {
        return "x = " + x + " y = " + y;
    }
}
