package main.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射测试类
 * 将Class中的类分为4部分进行说明：
 * 1.构造函数，Constructor
 * 2.成员方法，Method
 * 3.成员变量，Field
 * 4.类的其它信息(如注解、包名、类名、继承关系等等)
 * @author fanwei
 *
 */
public class TestMain
{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            IllegalArgumentException, InvocationTargetException
    {
        detainClass();
    }

    /**
     * 根据类的全限定符获取类
     * @throws ClassNotFoundException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     */
    public static void detainClass() throws ClassNotFoundException, NoSuchMethodException, SecurityException,
            IllegalArgumentException, InvocationTargetException
    {
        //根据“类名”获取 对应的Class对象
        Class<?> clazz = Class.forName("main.reflection.Demo");
        try
        {
            //1.构造函数
            Constructor constructor = clazz.getDeclaredConstructor();
            Object conObj = constructor.newInstance();
            System.out.println("conObj=" + conObj);

            //新建对象。newInstance()会调用类不带参数的构造函数
            Object object = clazz.newInstance();
            //2.对象方法
            Method setName = clazz.getDeclaredMethod("setName", new Class[]
            { String.class });
            setName.invoke(object, new Object[]
            { "fanwei" });
            Method getName = clazz.getDeclaredMethod("getName", new Class[]
            {});
            String name = (String) getName.invoke(object, new Object[]
            {});
            System.out.println("name=" + name);
            System.out.println("clazz=" + clazz);
            System.out.println("object=" + object);
        } catch (InstantiationException | IllegalAccessException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
