package task3;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Tests extends Mockito {
    private static WebService mockWebService;

    @BeforeClass
    public static void init(){
        mockWebService = new WebService();
        mockWebService = mock(WebService.class);
        when(mockWebService.getUserEmail(1)).thenReturn("vanesdacha@mail.ru");
        when(mockWebService.getUserEmail(2)).thenReturn("blablabla@mail.ru");
        when(mockWebService.getCurrentUrl()).thenReturn("https://mail.ru/");
        when(mockWebService.isRegisteredUser("vanesdacha@mail.ru")).thenReturn(true);
        when(mockWebService.isRegisteredUser(null)).thenReturn(false);
    }

    @Test
    public void negativeTest1(){
        Assert.assertFalse(mockWebService.isRegisteredUser(null));
    }

    @Test
    public void negativeTest2() {
        Assert.assertNotEquals(mockWebService.getUserEmail(1), null);
    }

    @Test
    public void positiveTest1(){
        Assert.assertTrue(mockWebService.isRegisteredUser("vanesdacha@mail.ru"));
    }

    @Test
    public void positiveTest2(){
        Assert.assertFalse(mockWebService.isRegisteredUser("blablabla@mail.ru"));
    }

    @Test
    public void positiveTest3() {
        Assert.assertEquals("blablabla@mail.ru", mockWebService.getUserEmail(2));
    }
}
