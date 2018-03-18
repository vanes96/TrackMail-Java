package task4;

import java.util.ArrayList;

public class Family
{
    private Parent mother, father;
    private ArrayList<Child> children = new ArrayList<Child>(5);

    private void printChildren()
    {
        System.out.println("Children:");
        for (Child child : children)
            child.print();
    }
    private void printParents()
    {
        System.out.println("Family\n------\nParents:");
        mother.print();
        father.print();
    }
    public void printAll()
    {
        printParents();
        System.out.println();
        printChildren();
    }
    public Family(Parent mother, Parent father, ArrayList<Child> children)
    {
        this.mother = mother;
        this.father = father;
        this.children.addAll(children);
    }
}
