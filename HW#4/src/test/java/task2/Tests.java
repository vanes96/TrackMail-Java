package task2;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class Tests {
    @Test
    public void checkCountPositive1()
    {
        int[] numbers = new int[]{23, 34, 5, 68, 8399};
        assertEquals("Неверное число цифр 3!",3, FinderThree.getThreeNumberCount(numbers));
    }
    @Test
    public void checkCountPositive2()
    {
        int[] numbers = new int[]{45, 22, 76890, 2451, 100, 112};
        assertThat("Неверное число цифр 3!", FinderThree.getThreeNumberCount(numbers), is(0));
    }
    @Test
    public void checkCountPositive3()
    {
        int[] numbers = new int[]{3, 33, 333};
        assertEquals("Неверное число цифр 3!", 6, FinderThree.getThreeNumberCount(numbers));
    }
    @Test(expected = Exception.class)
    public void checkCountNegative1()
    {
        assertNull("Не сработало исключение Exception!", FinderThree.getThreeNumberCount(new int[0]));

    }
    @Test(expected = NullPointerException.class)
    public void checkCountNegative2()
    {
        assertEquals("Не сработало исключение NullPointerException!", null, FinderThree.getThreeNumberCount(null));
    }
    @Test(expected = NullPointerException.class)
    public void checkCountNegative3()
    {
        int[] numbers = null;
        assertThat("Не сработало исключение NullPointerException!", FinderThree.getThreeNumberCount(numbers), nullValue());
    }
}
