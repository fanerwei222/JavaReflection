package main.reflection.multiple;

/**
 * 综合类 person
 * @author fanwei
 *
 */
public class MultiplePerson
{
    private String name;
    private Integer age;
    private String height;

    public MultiplePerson()
    {
        this.name = "default";
        this.age = 18;
        this.height = "166";
    }

    public MultiplePerson(String name, Integer age, String height)
    {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getHeight()
    {
        return height;
    }

    public void setHeight(String height)
    {
        this.height = height;
    }

}
