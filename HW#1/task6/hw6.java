package task6;

import common.In;
import common.Out;

public class hw6
{
    public void sortArray(int[][] a)
    {
        int n = a.length;
        int m = a[0].length;
        int count = 0;
        Out out = new Out();

        for (int i = 0; i < n; i++) {
            for (int k = m; k >= 2; k--) {
                for (int j = 0; j + 1 < k; j++) {
                    if (a[i][j] < a[i][j + 1] && (i + 1) % 2 == 1 || a[i][j] > a[i][j + 1] && (i + 1) % 2 == 0) {
                        int p = a[i][j + 1];
                        a[i][j + 1] = a[i][j];
                        a[i][j] = p;
                        count++;
                    }
                }
            }
        }

        out.print(a, " ");
        out.print(count);
    }

    public static void main(String[] args)
    {
        hw6 program = new hw6();
        In in = new In();
        int n = in.readNumber();
        int m = in.readNumber();

        program.sortArray(in.readArray(n, m));


    }
}
