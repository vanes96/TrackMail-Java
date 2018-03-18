package task3;
import common.In;
import common.Out;

public class hw3
{

    public int sumOfDigits(int a)
    {
        if (a < 10)
            return a;
        else
            return sumOfDigits(a / 10) + a % 10;
    }

    public static void main(String[] args)
    {
        In in = new In();
        Out out = new Out();
        hw3 program = new hw3();

        out.print(program.sumOfDigits(in.readNumber()));
    }
}
