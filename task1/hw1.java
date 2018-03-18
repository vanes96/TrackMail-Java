package task1;

import common.In;
import common.Out;

public class hw1
{
    public static void main(String[] args)
    {
        In in = new In();
        Out out = new Out();
        int n = in.readNumber();
        int[] a = in.readArray(n);
        for (int i = 0; i < n; i++)
            if (a[i] % 6 == 0)
                out.print(String.valueOf(a[i]) + ' ');
    }
}
