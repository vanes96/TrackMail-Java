package com.company;

import java.util.Scanner;

public class hw5 {

    public interface iOut<T>
    {
        public void print(T a);
    }

    public interface iIn<T>
    {
        public T read();
    }

    public class OutString implements iOut<String>{
        @Override
        public void print(String s)
        {
            System.out.print(s);
        }
    }

    public class InString implements iIn<String>{
        @Override
        public String read()
        {
            Scanner in = new Scanner(System.in);
            return in.nextLine();
        }
    }

    public void isPalindrome(String s)
    {
        s = s.replaceAll("\\s", "");
        StringBuffer buffer = new StringBuffer(s);
        buffer.reverse();
        if (s.compareToIgnoreCase(buffer.toString()) == 0)
            System.out.println("Палиндром");
        else
            System.out.println("Не палиндром");
    }

    public void start()
    {
        InString in = new InString();
        isPalindrome(in.read());
    }

    public static void main(String[] args)
    {
        hw5 program = new hw5();
        program.start();
    }
}
