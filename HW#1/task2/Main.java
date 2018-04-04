package Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Ternary ternaryObject = new Ternary();
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.print(ternaryObject.ternaryOperator.apply(s));
    }
}

//2. Дан предикат condition и две функции ifTrue и ifFalse.
//Напишите метод ternaryOperator, который из них построит новую функцию, возвращающую значение функции ifTrue, если предикат выполнен, и значение ifFalse иначе.
//Использовать нужно лямбда выражения и функциональные интерфейсы Java 8.