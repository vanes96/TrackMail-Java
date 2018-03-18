package task5;

import common.In;
import common.Out;

public class hw5
{
    public void isPalindrome(String s)
    {
        s = s.replaceAll("\\s", "");
        StringBuffer buffer = new StringBuffer(s);
        buffer.reverse();
        Out out = new Out();

        if (s.compareToIgnoreCase(buffer.toString()) == 0)
            out.print("Палиндром");
        else
            out.print("Не палиндром");
    }

    public static void main(String[] args)
    {
        In in = new In();
        hw5 program = new hw5();

        program.isPalindrome(in.readString());
    }
}
