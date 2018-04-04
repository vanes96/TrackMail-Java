package task4;

public class Child extends Parent
{
    public void print()
    {
        String role = getGender() ? "Son" : "Daughter";
        System.out.println(role + " - " + getName() + " " + "is " + getAge() + " years old");
    }

    public Child(boolean gender, String name, int age)
    {
        setGender(gender);
        setName(name);
        setAge(age);
    }
}