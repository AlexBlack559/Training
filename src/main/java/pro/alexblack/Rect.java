package pro.alexblack;

public class Rect {

    private Point origin;
    private Size size;

    public Rect(Point point1, Point point2) {
        origin = new Point(Math.min(point1.getX(), point2.getX()), Math.min(point1.getY(), point2.getY()));
        size = new Size(Math.abs(point1.getX() - point2.getX()), Math.abs(point1.getY() - point2.getY()));
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public double getArea() {
        return size.getWidth() * size.getHeight();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Rect)) {
            return false;
        }

        Rect rect = (Rect) obj;
        return origin == rect.origin && size == rect.size;
    }

    @Override
    public int hashCode() {
        int result = origin.hashCode();
        result = result * 31 + size.hashCode();
        return result;
    }
}
