import com.dudka.courses.positiveNumbers.PositiveNumbers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindPositiveNumbersTest {
    List<Integer> numbers;
    List<Integer> expectedPositiveNumbers;

    @Before
    public void initListWithNumbers() {
        numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(11);
        numbers.add(-3);
        numbers.add(-1);
        numbers.add(2);
        numbers.add(3);

    }


    @Before
    public void generateExpectedValue() {
        expectedPositiveNumbers = new ArrayList<>();
        expectedPositiveNumbers.add(11);
        expectedPositiveNumbers.add(10);
        expectedPositiveNumbers.add(3);
        expectedPositiveNumbers.add(2);
    }

    @Test
    public void findAllPositiveNumbersAndSortThemByDescendingOrderTest() {
        Assert.assertEquals(expectedPositiveNumbers, PositiveNumbers.findPositiveNumbers(null));
    }


}
