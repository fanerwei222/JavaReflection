package main.reflection;

/**
 * demo
 * @author fanwei
 *
 */
public class Demo
{
    private String name;
    private int age;

    public Demo()
    {
        System.out.println("调用main.reflection.Demo类的无参构造方法");
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

}
