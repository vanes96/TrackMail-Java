package Task5;

public class MyClass {

    public void printTable(@Argument(value = "") Integer number)
    {
        Integer[][] table = new Integer[number][number];

        for (int i = 0; i < number; i++)
        {
            System.out.print((i + 1) + ") ");
            for (int j = 0; j < number; j++)
            {
                table[i][j] = (i + 1) * (j + 1);
                System.out.print(table[i][j] + (table[i][j] < 10 ? "  ":" "));
            }
            System.out.println();
        }
    }
}
