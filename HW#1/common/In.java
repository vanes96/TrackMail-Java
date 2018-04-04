package common;

import java.util.Scanner;

public class In implements IIn
{
    Scanner in = new Scanner(System.in);
    public int[] readArray(int n)
    {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        return a;
    }
    public int[][] readArray(int n, int m)
    {
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = in.nextInt();
        return a;
    }
    public int readNumber()
    {
        return in.nextInt();
    }
    public String readString()
    {
        return in.nextLine();
    }
}