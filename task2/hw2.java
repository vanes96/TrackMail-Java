package task2;

import common.In;
import common.Out;

import java.util.Random;

public class hw2 {

    public int[] generateArray(int n)
    {
        int[] a = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++)
            a[i] = (random.nextInt(50) + 1) * 2;
        return a;
    }

    public static void main(String[] args)
    {
        hw2 program = new hw2();
        In in = new In();
        Out out = new Out();

        int n = in.readNumber();
        int[] a = program.generateArray(n);

        for (int i = 1; i < n; i += 2)
            a[i] *= a[i - 1];

        out.print(a, " ");
    }
}
