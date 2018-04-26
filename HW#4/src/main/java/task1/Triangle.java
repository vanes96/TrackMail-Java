package task1;

import java.lang.Math;

public class Triangle {
    private enum Vertices {
        A(0, 0),
        B(1, 1),
        C(-1, -1);

        private double x;
        private double y;

        Vertices(double x, double y) {
            this.x = x;
            this.y = y;
        }

        private double getX() {
            return x;
        }

        private  double getY()
        {
            return y;
        }
    }

    public double getAB()
    {
        return Math.floor(Math.sqrt(Math.pow(Vertices.A.getX() - Vertices.B.getX(), 2) + Math.pow(Vertices.A.getY() - Vertices.B.getY(), 2)) * 10) / 10;
    }

    public double getBC()
    {
        return Math.floor(Math.sqrt(Math.pow(Vertices.B.getX() - Vertices.C.getX(), 2) + Math.pow(Vertices.B.getY() - Vertices.C.getY(), 2)) * 10) / 10;
    }

    public double getAC()
    {
        return Math.floor(Math.sqrt(Math.pow(Vertices.A.getX() - Vertices.C.getX(), 2) + Math.pow(Vertices.A.getY() - Vertices.C.getY(), 2)) * 10) / 10;
    }
}
