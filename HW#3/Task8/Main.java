package Task8;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        //Scanner scanner = new Scanner(System.in);
        final String FILE_NAME = System.getProperty("user.dir") +"\\src\\Task8\\" + "input.txt";
        for (String str:Files.lines(Paths.get(FILE_NAME), StandardCharsets.UTF_8).collect(Collectors.toList()))
        {
            String[] split = str.replace("\\s","").split("\"");
            String date = split[0].replace(" ",""), format = split[1];

            Predicate<String> isCorrect = (d)-> d.matches(format);

            Consumer<String> printIsCorrect = (d) ->
            {
                if (isCorrect.test(d))
                    System.out.printf("Дата %s соответствует шаблону %s.", d, format);
                else
                    System.out.printf("Дата %s не соответствует шаблону %s.", d, format);
            };
            printIsCorrect.accept(date);
        }
    }
}
