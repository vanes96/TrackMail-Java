package Task3;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String string = scan.nextLine();

        String[] words = string.split("\\W");

        Stream stream = Arrays.stream(words);
        stream.filter((word) -> word.toString().
                length() > 5).filter((word) -> word.toString().
                toLowerCase().startsWith("a")).forEach((word) -> System.out.printf("%s:%d\n", word, word.toString().length()));
    }
}
