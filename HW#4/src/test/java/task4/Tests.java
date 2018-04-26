package task4;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class Tests {
    @Test
    public void checkPositive1()
    {
        assertEquals("Строки являются анаграммами!", true, AnagramChecker.isAnagram("qwerty", "ertyqw"));
    }

    @Test
    public void checkPositive2()
    {
        assertThat("Строки не являются анаграммами!", AnagramChecker.isAnagram("qwerty", "ertyQw"), is(false));
    }

    @Test
    public void checkCountNegative1()
    {
        assertThat("Пустые строки являются анаграммами!", AnagramChecker.isAnagram("", ""), is(true));
    }

    @Test(expected = NullPointerException.class)
    public void checkCountNegative2()
    {
        assertEquals("Не сработало исключение NullPointerException!", true, AnagramChecker.isAnagram(null, ""));
    }
}
