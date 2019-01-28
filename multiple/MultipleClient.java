package main.reflection.multiple;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 综合类客户端
 * @author fanwei
 *
 */
public class MultipleClient
{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException,
            NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException
    {
        /**
         * 获取类的四种方法
         * 1. Class.forName("完整类名");
         * 2. 类名.class;
         * 3."类名字符串".getClass();
         * 4. 实例对象.getClass();
         */
        Class<?> clazz = Class.forName("main.reflection.multiple.MultiplePerson");
        Class<?> clazz2 = MultiplePerson.class;
        Class<?> clazz3 = "main.reflection.multiple.MultiplePerson".getClass();
        MultiplePerson person = new MultiplePerson();
        Class<?> clazz4 = person.getClass();

        /**
         * 获取显示声明的构造函数
         */
        Constructor<?> constructor = clazz.getDeclaredConstructor();
        /**
         * 通过构造函数创建实例
         */
        Object object1 = constructor.newInstance();

        /**
         * 获取显示声明字段
         */
        Field name = clazz.getDeclaredField("name");
        Field age = clazz.getDeclaredField("age");
        Field height = clazz.getDeclaredField("height");

        /**
         * private字段需要设置可访问标识为true
         */
        name.setAccessible(true);
        age.setAccessible(true);
        height.setAccessible(true);

        /**
         * 给获取的字段赋值
         */
        name.set(object1, "HelloKitty");
        age.set(object1, 99);
        height.set(object1, "3333333");
        System.out.println(object1 + "\n");

        /**
         * 获取显示声明的有参数的构造函数
         */
        Constructor<?> constructor2 = clazz.getDeclaredConstructor(new Class[]
        { String.class, Integer.class, String.class });
        Object object2 = constructor2.newInstance("fanwei", 24, "188");
        System.out.println(object1);
        System.out.println(object2);

        /**
         * 获取显示声明的所有方法
         */
        Method[] methods = clazz.getDeclaredMethods();
        /**
         * 根据方法名获取显示声明的方法
         */
        Method getName = clazz.getDeclaredMethod("getName", new Class[]
        {});
        Method getAge = clazz.getDeclaredMethod("getAge", new Class[]
        {});
        Method getHeight = clazz.getDeclaredMethod("getHeight", new Class[]
        {});
        /**
         * 通过方法名获取显示声明的方法
         */
        Method setName = clazz.getDeclaredMethod("setName", new Class[]
        { String.class });
        Method setAge = clazz.getDeclaredMethod("setAge", new Class[]
        { Integer.class });
        Method setHeight = clazz.getDeclaredMethod("setHeight", new Class[]
        { String.class });
        /**
         * 执行获取到的方法
         */
        setName.invoke(object1, new Object[]
        { "LuoNaErduo" });
        setAge.invoke(object1, new Object[]
        { 27 });
        setHeight.invoke(object1, new Object[]
        { "190" });
        /**
         * 执行获取到的方法
         */
        String oname = (String) getName.invoke(object1, new Object[]
        {});
        Integer oage = (Integer) getAge.invoke(object1, new Object[]
        {});
        String oheight = (String) getHeight.invoke(object1, new Object[]
        {});
        System.out.println(oname + "\n" + oage + "\n" + oheight + "\n");
        System.out.println("==========================end===============================");
    }
}
