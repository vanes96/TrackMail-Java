package task1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.awt.*;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

@RunWith(Suite.class)
@Suite.SuiteClasses({Tests.class})
public class Tests {
//    @Test(expected = NullPointerException.class)
//    public void checkNumStrNegative()
//    {
//        String expected = "Пять";
//        int a = 5;
//        int b = 4;
//        //Assert.assertEquals(numStr(a, b, null), expected);
//    }
    @Test
    public void positiveTest1()
    {
        ArrayList<Point> points = new ArrayList<Point>(5);
        points.add(new Point(0,0));
        points.add(new Point(0, 2));
        points.add(new Point(4,0));
        points.add(new Point(2, 2));
        points.add(new Point(5, 3));

        Assert.assertEquals(true, Main.isRectangular(points.get(0), points.get(1), points.get(2)));
    }


}
