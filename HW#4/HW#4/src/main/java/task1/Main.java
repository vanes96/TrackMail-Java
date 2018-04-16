package task1;

import java.awt.*;
import java.lang.Math;
import java.util.ArrayList;

public class Main {
    public static boolean isIsosceles(Point point1, Point point2, Point point3)
    {
        double dist12 = getDistance(point1, point2), dist13 = getDistance(point1, point3), dist23 = getDistance(point2, point3);
        if (dist12 == dist13 || dist12 == dist23 || dist13 == dist23)
            return true;
        else
            return false;
    }
    public static boolean isEquilateral(Point point1, Point point2, Point point3)
    {
        double dist12 = getDistance(point1, point2), dist13 = getDistance(point1, point3), dist23 = getDistance(point2, point3);
        if (dist12 == dist13 && dist12 == dist23 && dist13 == dist23)
            return true;
        else
            return false;
    }
    public static boolean isRectangular(Point point1, Point point2, Point point3)
    {
        double dist12 = getDistance(point1, point2), dist13 = getDistance(point1, point3), dist23 = getDistance(point2, point3);
        double max = Math.max(dist12, Math.max(dist13, dist23));
        ArrayList<Double> dists = new ArrayList<Double>(3);
        dists.add(dist12);
        dists.add(dist13);
        dists.add(dist23);
        int index_max = dists.indexOf(max);
        ArrayList<Double> sides = new ArrayList<Double>(2);
        for (int i = 0; i < 3; i++)
            if (i != index_max)
                sides.add(dists.get(i));
        if (Math.abs(max * max - (sides.get(0) * sides.get(0) + sides.get(1) * sides.get(1))) < 0.1)
            return true;
        else
            return false;
    }
    public static double getDistance(Point point1, Point point2)
    {
        double distance = Math.floor(Math.sqrt(Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2)) * 100) / 100;
        return distance;
    }
}
