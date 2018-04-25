package Task5;

import java.lang.reflect.Method;

public class TableMultiplication {

    @Argument(value = 9)
    public void printTable() {
        Class<?> clazz = this.getClass();
        Method method = clazz.getMethods()[0];
        if(method.isAnnotationPresent(Argument.class)) {
            Argument argument = method.getAnnotation(Argument.class);
            printMultiply(argument.value());
        }
    }

    private void printMultiply(int number) {
        int[][] table = new int[number][number];
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
