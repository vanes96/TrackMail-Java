package task4;

public class Parent extends Human
{
    public Parent()
    {
        setGender(true);
        setName("Ivan");
        setAge(21);
    }
    public Parent(boolean gender, String name, int age)
    {
        setGender(gender);
        setName(name);
        setAge(age);
    }
    public void print()
    {
        String role = getGender() ? "Father" : "Mother";
        System.out.println(role + " - " + getName() + " " + "is " + getAge() + " years old");
    }
}
