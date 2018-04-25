package Task8;

import com.sun.prism.shader.Solid_TextureYV12_Loader;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        String ProjectDirectory = System.getProperty("user.dir") +"\\src\\Task8\\files\\";
        String[] fileNames = Files.walk(Paths.get(ProjectDirectory))
                .filter(Files::isRegularFile)
                .collect(Collectors.toList()).toString().replaceAll("\\[|\\]","").split(", ");

        for (String fileName: fileNames)
        {
            System.out.println(fileName.replace(ProjectDirectory,""));
            for (String str:Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).collect(Collectors.toList()))
            {
                String[] split = str.replace("\\s","").split("\"");
                String date = split[0].replace(" ",""),
                        formatInput = split[1];

                final String[] replaceFinal = {""};
                UnaryOperator<String> updateFormat = (form)->
                {
                    String format = form;
                    format = format.toLowerCase();
                    String[] parts = format.split("\\W");
                    String replacement = "";
                    for (int i = 0; i < 3; i++)
                    {
                        String part = parts[i];
                        int partLength = part.length();
                        replacement = "";
                        if (part.contains("d"))
                        {
                            if (partLength == 2)
                                replacement = "\\\\d{2}";
                        }
                        else if (part.contains("m"))
                        {
                            if (partLength == 2)
                                replacement = "\\\\d{2}";
                            else if (partLength > 2)
                                replacement = "\\\\w{" + String.valueOf(partLength) + "}";
                        }
                        else if (part.contains("y"))
                        {
                            if (partLength == 2 || partLength == 4)
                                replacement = "\\\\d{" + String.valueOf(partLength) + "}";
                        }
                        if (!replacement.isEmpty())
                            format = format.replaceAll(part, replacement);
                        else
                            break;
                    }
                    replaceFinal[0] = replacement;
                    return format;
                };

                Predicate<String> isCorrect = (d)-> d.matches(updateFormat.apply(formatInput));

                Consumer<String> printIsCorrect = (d) ->
                {
                    if (isCorrect.test(d))
                        System.out.printf("Дата %s соответствует шаблону %s.\n\n", d, formatInput);
                    else if (!replaceFinal[0].isEmpty())
                        System.out.printf("Дата %s не соответствует шаблону %s.\n\n", d, formatInput);
                    else
                        System.out.printf("Шаблон %s не корректный!\n\n", formatInput);
                };
                printIsCorrect.accept(date);
            }
        }
    }

}
