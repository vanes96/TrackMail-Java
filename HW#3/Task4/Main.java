package Task4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String,String> students = new HashMap<String,String>();
        Map<String, Integer> faculties = new TreeMap<String, Integer>();
        Scanner scanner = new Scanner(System.in);
        final String FILE_NAME = System.getProperty("user.dir") +"\\src\\Task4\\" + "input.txt";

        for (String str:Files.lines(Paths.get(FILE_NAME), StandardCharsets.UTF_8).collect(Collectors.toList()))
        {
            List<String> words = Stream.of(str.split("\\s")).map (word -> new String(word)).collect(Collectors.toList());
            String student = words.get(0) + " " + words.get(1) + " " + words.get(2);
            String faculty = words.get(3);

            if (faculties.containsKey(faculty))
                faculties.replace(faculty, faculties.get(faculty) + 1);
            else
                faculties.put(faculty, 1);

            students.put(student, faculty);
        }

        System.out.println("Факультеты по алфавиту:");
        for (String fac:faculties.keySet())
            System.out.println(fac);

        //faculties = sortByValue(faculties);
        faculties.entrySet().stream() .sorted(Map.Entry.<String, Integer>comparingByValue().
                  reversed()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("\n3 самых популярных факультета:");
        int i = 1;
        for (String fac : faculties.keySet()) {
            System.out.println(String.valueOf(i) + ") " + fac + " " + faculties.get(fac));
            i++;
            if (i > 3)
                break;;
        }
    }
    //    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortedMap)
//    {
//        List<Map.Entry<String, Integer>> list =
//                new LinkedList<Map.Entry<String, Integer>>(unsortedMap.entrySet());
//
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//            public int compare(Map.Entry<String, Integer> a,
//                               Map.Entry<String, Integer> b) {
//                return (b.getValue()).compareTo(a.getValue());
//            }
//        });
//
//        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
//        for (Map.Entry<String, Integer> entry : list) {
//            sortedMap.put(entry.getKey(), entry.getValue());
//        }
//
//        return sortedMap;
//    }
}


