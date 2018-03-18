package task4;

public abstract class Human
{
    private boolean gender;
    private int age;
    private String name;

    public boolean getGender()
    {
        return gender;
    }
    public void setGender(boolean gender)
    {
        this.gender = gender;
    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
}
