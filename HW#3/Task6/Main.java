package Task6;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args)
    {
        int[] counts = new int[3];
        Field[] fields = MyClass.class.getDeclaredFields();

        Consumer<int[]> printCounts = (array) ->
        {
            System.out.printf("Public полей: %d\n", array[0]);
            System.out.printf("Protected полей: %d\n", array[1]);
            System.out.printf("Private полей: %d\n", array[2]);
        };

        for(Field field : fields){
            int modifier = field.getModifiers();
            if (Modifier.isPublic(modifier))
                counts[0] += 1;
            else
            if (Modifier.isProtected(modifier))
                counts[1] += 1;
            else
            if (Modifier.isPrivate(modifier))
                counts[2] += 1;
        }

        printCounts.accept(counts);
    }
}
