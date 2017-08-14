package TestRefactor;

import TestClass.UnderAnalyzeClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by panting1 on 2017/8/14.
 */
public class RefactorClass {
    public static void run() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //0、获取class
        Class cl = Class.forName("TestClass.UnderAnalyzeClass");//返回指定名称的Class对象

        //1、输出类的实例
        UnderAnalyzeClass underAnalyzeClass = (UnderAnalyzeClass)cl.newInstance();//返回class的实例
        System.out.println(underAnalyzeClass.getName() + " " + underAnalyzeClass.getAge());
        underAnalyzeClass.setName("ArbitaryName");
        underAnalyzeClass.setAge(100);
        System.out.println(underAnalyzeClass.getName() + " " + underAnalyzeClass.getAge());

        //2、输出class名称
        Class supercl = cl.getSuperclass();
        System.out.print("class UnderAnalyzeClass");
        if (supercl != null && supercl != Object.class)//打印父类名称
            System.out.print(" extends " + supercl.getName());
        System.out.print("\n{\n");//{

        //3、打印构造器：getConstructors返回公有构造器
        Constructor[] constructors = cl.getDeclaredConstructors();//获取全部声明的构造器（包括私有和保护）
        for (Constructor c : constructors)
        {
            String name = c.getName();
            System.out.print("   " + Modifier.toString(c.getModifiers()));//getModifiers返回作用于修饰符
            System.out.print(" " + name + "(");//构造器名字
            // print parameter types
            Class[] paramTypes = c.getParameterTypes();//参数列表
            for (int j = 0; j < paramTypes.length; j++)
            {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());//参数的名称
            }
            System.out.println(");");
        }

        //4、打印方法:getMethods返回所有的公有方法，包括从超类继承的公有方法
        Method[] methods = cl.getDeclaredMethods();//获取全部声明的方法，但不包括超类的方法
        for (Method m : methods)
        {
            Class retType = m.getReturnType();//获取方法返回类型的class对象
            String name = m.getName();//方法名称
            // print modifiers, return type and method name
            System.out.print("   " + Modifier.toString(m.getModifiers()));//方法的作用域
            System.out.print(" " + retType.getName() + " " + name + "(");//方法的返回类型
            // print parameter types
            Class[] paramTypes = m.getParameterTypes();//获取参数类型的class数组
            for (int j = 0; j < paramTypes.length; j++)
            {
                if (j > 0) System.out.print(", ");
                System.out.print(paramTypes[j].getName());
            }
            System.out.println(");");
        }

        //5、打印所有属性 getFields返回该类及超类的所有公有属性
        Field[] fields = cl.getDeclaredFields();//返回全部属性
        for (Field f : fields)
        {
            Class type = f.getType();//属性的Class类型
            String name = f.getName();//属性名称
            System.out.print("   " + Modifier.toString(f.getModifiers()));//返回属性的作用域
            System.out.println(" " + type.getName() + " " + name + ";");
        }

        System.out.println("}");//}
    }
}
/* 控制台打印
null null
ArbitaryName 100
class UnderAnalyzeClass
{
   public TestClass.UnderAnalyzeClass(java.lang.String, java.lang.Integer);
   public TestClass.UnderAnalyzeClass();
   public java.lang.String getName();
   public void setName(java.lang.String);
   public void setAge(java.lang.Integer);
   public java.lang.Integer getAge();
   private java.lang.String name;
   public java.lang.Integer age;
}
 */
