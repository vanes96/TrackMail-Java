package com.company;

import java.util.Random;
import java.util.Scanner;

public class hw2 {
    public interface iOut
    {
        public void printArray(int[] a, int n, String sep);
        public void printNumber(int a, String sep);
    }

    public interface iIn
    {
        public int[] readArray(int n);
        public int readNumber();
    }

    public class InInt implements iIn
    {
        Scanner in = new Scanner(System.in);
        public int[] readArray(int n)
        {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = in.nextInt();
            return a;
        }
        public int readNumber()
        {
            return in.nextInt();
        }
        public InInt()
        {}
    }

    public class OutInt implements iOut
    {
        public void printArray(int[] a, int n, String sep)
        {
            for (int i = 0; i < n; i++)
                System.out.print(a[i] + sep);
        }
        public void printNumber(int a, String sep)
        {
            System.out.print(a + sep);
        }
        public OutInt()
        {}
    }

    public int[] generateArray(int n)
    {
        int[] a = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++)
            a[i] = (random.nextInt(50) + 1) * 2;
        return a;
    }

    public void start()
    {
        InInt in = new InInt();
        OutInt out = new OutInt();

        int n = in.readNumber();
        int[] a = generateArray(n);

        for (int i = 1; i < n; i += 2)
            a[i] *= a[i - 1];

        out.printArray(a, n, " ");
    }


    public static void main2(String[] args)
    {
        hw2 program = new hw2();
        program.start();
    }
}
