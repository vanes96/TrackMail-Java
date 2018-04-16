package task4;

import java.util.Arrays;

public class Main {
    public static boolean isAnagram(String str1, String str2) {
        try{
            if (str1.length() != str2.length())
                return false;
            char[] a = str1.toCharArray();
            char[] b = str2.toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            return Arrays.equals(a, b);
        }
        catch (Exception e)
        {
            throw new NullPointerException("Строка(и) не существует(ют)!");
        }

    }
}
