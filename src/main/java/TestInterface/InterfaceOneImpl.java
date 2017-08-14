package TestInterface;

/**
 * Created by panting1 on 2017/8/5.
 */
public class InterfaceOneImpl implements InterfaceOne {
    @Override
    public void fun(){
        //name = "xx";//不能修改interface的final变量
        System.out.println("implements  interface fun(), name="+name);
    }
}
