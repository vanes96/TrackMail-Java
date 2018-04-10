package Task5;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        MyClass obj = new MyClass();
        Scanner scanner = new Scanner(System.in);
        obj.printTable(scanner.nextInt());
    }
}
