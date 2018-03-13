package com.company;

import javafx.scene.Parent;

import java.util.ArrayList;
import java.util.Scanner;

public class hw4 {
    public interface iOut
    {
        public void printArray(int[] a, int n, String sep);
        public void printNumber(int a, String sep);
    }

    public interface iIn
    {
        public int[] readArray(int n);
        public int readNumber();
    }

    public class InInt implements iIn
    {
        Scanner in = new Scanner(System.in);
        public int[] readArray(int n)
        {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = in.nextInt();
            return a;
        }
        public int readNumber()
        {
            return in.nextInt();
        }
        public InInt()
        {}
    }

    public class OutInt implements iOut
    {
        public void printArray(int[] a, int n, String sep)
        {
            for (int i = 0; i < n; i++)
                System.out.print(a[i] + sep);
        }
        public void printNumber(int a, String sep)
        {
            System.out.print(a + sep);
        }
        public OutInt()
        {}
    }

    public abstract class human
    {
        protected boolean gender;
        protected int age;
        protected String name;

        public boolean getGender()
        {
            return gender;
        }
        public int getAge()
        {
            return age;
        }
        public String getName()
        {
            return name;
        }
    }

    public class family
    {
        private parent mother, father;
        private ArrayList<child> children = new ArrayList<child>(5);

        public void printChildren()
        {
            System.out.println("Children:");
            for (child child : children)
                child.print();
        }
        public void printParents()
        {
            System.out.println("Parents:");
            mother.print();
            father.print();
        }
        public void printAll()
        {
            printParents();
            System.out.println();
            printChildren();
        }
        public family(parent mother, parent father, ArrayList<child> children)
        {
            this.mother = mother;
            this.father = father;
            this.children.addAll(children);
        }
    }

    public class parent extends human
    {
        public parent()
        {
            this.gender = true;
            this.name = "Ivan";
            this.age = 21;
        }
        public parent(boolean gender, String name, int age)
        {
            this.gender = gender;
            this.name = name;
            this.age = age;
        }
        public void print()
        {
            String role = gender ? "Father" : "Mother";
            System.out.println(role + ": " + name + " " + "is " + age + " years old");
        }
    }

    public class child extends parent
    {
        @Override
        public void print()
        {
            String role = gender ? "Son" : "Daughter";
            System.out.println(role + ": " + name + " " + "is " + age + " years old");
        }
        public child(boolean gender, String name, int age)
        {
            this.gender = gender;
            this.name = name;
            this.age = age;
        }
    }

    public void start()
    {
        parent mother = new parent(false, "Emma", 55);
        parent father = new parent(true, "Vladimir", 60);
        ArrayList<child> children = new ArrayList<child>(2);

        children.add(new child(true,"Ivan", 21));
        children.add(new child(false,"Larisa", 29));

        family family = new family(mother, father, children);
        family.printAll();
    }

    public static void main(String[] args)
    {
        hw4 program = new hw4();
        program.start();
    }
}
