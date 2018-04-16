package task4;

import org.junit.Test;

import java.util.regex.Matcher;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class Tests {
//    @Test(expected = NullPointerException.class)
    @Test
    public void checkPositive1()
    {
        assertEquals(true, Main.isAnagram("qwerty", "ertyqw"));
    }
    @Test
    public void checkPositive2()
    {
        assertThat(Main.isAnagram("qwerty", "ertyQw"), is(false));
    }
    @Test
    public void checkCountNegative1()
    {
        assertThat(Main.isAnagram("", ""), is(true));
    }
    @Test(expected = NullPointerException.class)
    public void checkCountNegative2()
    {
        assertEquals(true,Main.isAnagram(null, ""));
    }
}
