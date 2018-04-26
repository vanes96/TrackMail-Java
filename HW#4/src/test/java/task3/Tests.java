package task3;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

public class Tests extends Mockito {
    private static WebService mockWebService;

    @BeforeClass
    public static void initialize(){
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
        Assert.assertFalse("Пользователь не зарегистрирован!", mockWebService.isRegisteredUser(null));
    }

    @Test
    public void negativeTest2() {
        Assert.assertNotEquals("Данный ID не должен соответствовать null!", mockWebService.getUserEmail(1), null);
    }

    @Test
    public void positiveTest1(){
        Assert.assertTrue("Данный пользователь зарегистрирован!", mockWebService.isRegisteredUser("vanesdacha@mail.ru"));
    }

    @Test
    public void positiveTest2(){
        Assert.assertFalse("Данный пользователь зарегистрирован!", mockWebService.isRegisteredUser("blablabla@mail.ru"));
    }

    @Test
    public void positiveTest3() {
        Assert.assertEquals("Пользователь соответствует указанному ID!", "blablabla@mail.ru", mockWebService.getUserEmail(2));
    }

    @AfterClass
    public static void clear(){
        mockWebService = null;
    }
}
