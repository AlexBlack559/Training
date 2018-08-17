package pro.alexblack;

public class Size {
    private int width;
    private int height;

    public Size(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "width = " + width + " height = " + height;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Size)) {
            return false;
        }

        Size size = (Size) obj;
        return size.width == width && size.height == height;
    }

    @Override
    public int hashCode() {
        int result = width;
        result = result * 31 + height;

        return result;
    }
}
