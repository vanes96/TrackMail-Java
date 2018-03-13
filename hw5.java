package com.company;

import java.util.Scanner;

public class hw5 {

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
        Scanner in = new Scanner(System.in);
        isPalindrome(in.nextLine());
    }

    public static void main(String[] args)
    {
        hw5 program = new hw5();
        program.start();
    }
}
