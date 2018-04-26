package task1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import task1.types.*;
import static junit.framework.TestCase.assertTrue;

public class Tests {
    private static Triangle triangle;

    @BeforeClass
    public static void initialize()
    {
        triangle = new Triangle();
    }

    @Test
    @Category(Rectangular.class)
    public void isRectangular(){
        assertTrue("Треугольник не прямоугольный.",
                (Math.pow(triangle.getAB(), 2) == Math.pow(triangle.getAC(), 2) + Math.pow(triangle.getBC(), 2))
                        ||(Math.pow(triangle.getAC(), 2) == Math.pow(triangle.getAB(), 2) + Math.pow(triangle.getBC(), 2))
                        ||(Math.pow(triangle.getBC(), 2) == Math.pow(triangle.getAB(), 2) + Math.pow(triangle.getAC(), 2)));
    }

    @Test
    @Category(Equilateral.class)
    public void isEquilateral(){
        assertTrue("Треугольник не равносторонний.",
                triangle.getAB() == triangle.getAC() && triangle.getAB() == triangle.getBC());
    }

    @Test
    @Category(Isosceles.class)
    public void isIsosceles(){
        assertTrue("Треугольник не равнобедренный.",
                triangle.getAB() == triangle.getAC() || triangle.getAB() == triangle.getBC() ||triangle.getAC() == triangle.getBC());
    }

    @AfterClass
    public static void clear()
    {
        triangle = null;
    }

}
