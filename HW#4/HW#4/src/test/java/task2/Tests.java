package task2;

import org.junit.Test;

import java.util.regex.Matcher;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class Tests {

    @Test
    public void checkCountPositive1()
    {
        int expected = 3;
        int[] numbers = new int[]{23, 34, 5, 68, 8399};
        assertEquals(expected, Main.getThreeNumberCount(numbers));
    }
    @Test
    public void checkCountPositive2()
    {
        int expected = 0;
        int[] numbers = new int[]{45, 22, 76890, 2451, 100, 112};
        assertThat(Main.getThreeNumberCount(numbers), is(expected));
    }
    @Test
    public void checkCountPositive3()
    {
        int expected = 6;
        int[] numbers = new int[]{3, 33, 333};
        assertEquals(expected, Main.getThreeNumberCount(numbers));
    }
    @Test(expected = Exception.class)
    public void checkCountNegative1()
    {
        int[] numbers = new int[0];
        assertNull(Main.getThreeNumberCount(numbers));

    }
    @Test(expected = NullPointerException.class)
    public void checkCountNegative2()
    {
        int[] numbers = null;
        assertEquals(null, Main.getThreeNumberCount(numbers));
    }
    @Test(expected = NullPointerException.class)
    public void checkCountNegative3()
    {
        int[] numbers = null;
        assertThat(Main.getThreeNumberCount(numbers),nullValue());
    }


}
