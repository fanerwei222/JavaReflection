package main.reflection;

/**
 * 获取字节码文件（class文件）的三种方式
 * @author fanwei
 *
 */
public class TestGetClazzLane
{
    public static void main(String[] args) throws ClassNotFoundException
    {
        //getObjectOne();
        //getObjectTwo();
        //getObjectThree();
        getObjectFour();
    }

    /**
     * 1.Object类中的getClass()方法的。
     * 想要用这种方式，必须要明确具体的类，并创建对象。
     * 比较麻烦
     */
    public static void getObjectOne()
    {
        Demo demo = new Demo();
        Class<? extends Demo> clazz = demo.getClass();
        System.out.println(clazz);
        Class<? extends Demo> clazz2 = demo.getClass();
        System.out.println(clazz2);
    }

    /**
     * 2.
     * 任何数据类型(基本数据类型和引用数据类型)都具备一个静态的属性.class来获取其对应的Class对象。
     * 相对简单，但是还是要明确用到类中的静态成员。
     * 还是不够扩展。 
     */
    public static void getObjectTwo()
    {
        Class clazz = Demo.class;
        Class clazz2 = Demo.class;
        System.out.println(clazz);
        System.out.println(clazz2);
        System.out.println(clazz == clazz2);
    }

    /**
     * 3.
     * 只要通过给定的类的 字符串名称就可以获取该类，更为扩展。
     * 可以用Class类中的方法完成。
     * 该方法就是forName.
     * 这种方式只要有名称即可，更为方便，扩展性更强。
     * @throws ClassNotFoundException
     */
    public static void getObjectThree() throws ClassNotFoundException
    {
        String clazzName = "main.reflection.Demo";
        Class clazz = Class.forName(clazzName);
        System.out.println(clazz);
    }

    /**
     * 4.此方法不行，获取到的是java.lang.String
     * "类名字符串".getClass()
     */
    public static void getObjectFour()
    {
        String str = "main.reflection.Demo";
        Class clazz = str.getClass();
        System.out.println(clazz);
    }

}
