package pro.alexblack.geometry;

public class Rect {

    private Point origin;
    private Size size;

    public Rect() {
        origin = new Point();
        size = new Size();
    }

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

    public double getIntersectionArea(Rect other) {
        if (intersectsWithRect(other)) {

            if (isInsideRect(other)) {
                return getArea();
            } else if (other.isInsideRect(this)) {
                return other.getArea();
            } else {
                int height = Math.max(other.maxX(), maxX()) - Math.min(other.maxX(), maxX());
                int width = Math.max(other.maxY(), maxY()) - Math.min(other.maxY(), maxY());
                return width * height;
            }
        }

        return 0;
    }

    public boolean intersectsWithRect(Rect other) {
        return minX() < other.maxX() && maxX() > other.minX() && minY() < other.maxY() && maxY() > other.minY();
    }

    public boolean isInsideRect(Rect other) {
        return minX() > other.minX() && maxX() < other.maxX() && minY() > other.minY() && maxY() < other.maxY();
    }

    int maxX() {
        return origin.getX() + size.getWidth();
    }

    int maxY() {
        return origin.getY() + size.getHeight();
    }

    int minX() {
        return origin.getX();
    }

    int minY() {
        return origin.getY();
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
