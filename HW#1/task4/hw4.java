package task4;

import java.util.ArrayList;

public class hw4
{
    public static void main(String[] args)
    {
        Parent mother = new Parent(false, "Emma", 55);
        Parent father = new Parent(true, "Vladimir", 60);
        ArrayList<Child> children = new ArrayList<Child>(2);

        children.add(new Child(true,"Ivan", 21));
        children.add(new Child(false,"Larisa", 29));

        Family family = new Family(mother, father, children);
        family.printAll();
    }
}
