import com.dudka.courses.shapes.Shape;
import com.dudka.courses.shapes.shapesImpl.Ball;
import com.dudka.courses.shapes.shapesImpl.Cube;
import com.dudka.courses.shapes.shapesImpl.Pyramid;
import com.dudka.courses.shapes.sortShapes.SortShapes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SortFiguresByVolumeTest {

    List<Shape> shapes;
    List<Shape> expectedValuesList;

    @Before
    public void initListWithFigures() {
        shapes = new ArrayList<>();
        shapes.add(new Cube(3));
        shapes.add(new Pyramid(2, 3));
        shapes.add(new Ball(5));
    }


    @Before
    public void generateExpectedValues() {
        expectedValuesList = new ArrayList<>();
        expectedValuesList.add(new Pyramid(2, 3));
        expectedValuesList.add(new Ball(5));
        expectedValuesList.add(new Cube(3));
    }

    @Test
    public void sortFiguresByVolume() {
        Assert.assertEquals(expectedValuesList, SortShapes.sortFiguresByVolume(shapes));
    }
}
