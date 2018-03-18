package common;

public class Out implements IOut
{
    public void print(int[] a, String sep)
    {
        int n = a.length;
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + sep);
    }
    public void print(int[][] a, String sep)
    {
        int n = a.length;
        int m = a[0].length;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
                System.out.print(a[i][j] + sep);
            System.out.println();
        }
    }
    public void print(int a)
    {
        System.out.print(a);
    }
    public void print(String s)
    {
        System.out.print(s);
    }
}
