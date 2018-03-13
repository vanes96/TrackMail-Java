package com.company;

import java.util.Scanner;

public class hw3 {
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

    public int sumOfDigits(int a)
    {
        if (a < 10)
            return a;
        else
            return sumOfDigits(a / 10) + a % 10;
    }

    public void start()
    {
        InInt in = new InInt();
        OutInt out = new OutInt();

        int a = in.readNumber();
        out.printNumber(sumOfDigits(a),"");
    }


    public static void main3(String[] args)
    {
        hw3 program = new hw3();
        program.start();
    }
}
