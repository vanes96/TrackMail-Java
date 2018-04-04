package Task1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>(n);

        for (int i = 0; i < n; i++)
            list.add(i, random.nextInt(50));


        Predicate<Integer> isEven = (x) -> x % 2 == 0;
        Consumer<ArrayList<Integer>> printList = (aList) ->
        {
            for (Integer elem:aList)
                System.out.printf("%d ", elem * (isEven.test(elem) ? 3 : 5));
        };

        printList.accept(list);
    }
}
