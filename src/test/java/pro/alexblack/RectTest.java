package pro.alexblack;

import org.junit.jupiter.api.Test;
import pro.alexblack.geometry.Point;
import pro.alexblack.geometry.Rect;
import pro.alexblack.geometry.Size;

import static org.junit.jupiter.api.Assertions.*;


class RectTest {

    @Test
    void testTopLeftBottomRightPointsResultsCorrectRect() {
        // Given
        Point topLeft = new Point(100, 100);
        Point bottomRight = new Point(200, 200);

        // When
        Rect rect = new Rect(topLeft, bottomRight);

        // Then
        assertEquals(new Point(100, 100), rect.getOrigin());
        assertEquals(new Size(100, 100), rect.getSize());
    }

    @Test
    void testBottomLeftTopRightPointsResultsCorrectRect() {
        // Given
        Point bottomLeft = new Point(100, 200);
        Point topRight = new Point(200, 100);

        // When
        Rect rect = new Rect(bottomLeft, topRight);

        // Then
        assertEquals(new Point(100, 100), rect.getOrigin());
        assertEquals(new Size(100, 100), rect.getSize());
    }

    @Test
    void testNegativePointValuesResultsCorrectRect() {
        // Given
        Point bottomLeft = new Point(-100, 100);
        Point topRight = new Point(100, -100);

        // When
        Rect rect = new Rect(topRight, bottomLeft);

        // Then
        assertEquals(new Point(-100, -100), rect.getOrigin());
        assertEquals(new Size(200, 200), rect.getSize());
    }

    @Test
    void testIntersectionAreaRectIntersectsWithRect() {
        // Given
        Rect rect1 = new Rect(new Point(0, 0), new Point(10, 10));
        Rect rect2 = new Rect(new Point(5, 5), new Point(15, 15));

        // When
        double area = rect1.getIntersectionArea(rect2);

        // Then
        assertEquals(25, area);
    }

    @Test
    void testIntersectionAreaRectInsideRect() {
        // Given
        Rect rect1 = new Rect(new Point(0, 0), new Point(100, 100));
        Rect rect2 = new Rect(new Point(25, 25), new Point(75, 75));

        // When
        double area = rect1.getIntersectionArea(rect2);

        // Then
        assertEquals(2500, area);
    }
}