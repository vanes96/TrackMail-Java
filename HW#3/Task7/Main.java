package Task7;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String octet = "(\\d|\\w)(\\d|\\w)";
        String patternMAC = octet + ':' + octet + ':' + octet + ':' + octet + ':' + octet + ':' + octet;
        Predicate<String> isMAC = (mac)-> mac.matches(patternMAC);

        Consumer<String> printIsMAC = (str) ->
        {
            if (isMAC.test(str))
                System.out.printf("MAC адрес %s верный.", str);
            else
                System.out.printf("MAC адрес %s не верный.", str);
        };
        printIsMAC.accept(scanner.nextLine());
    }
}
