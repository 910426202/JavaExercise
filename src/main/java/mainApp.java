import TestInterface.InterfaceOneImpl;
import TestInterface.InterfaceTest;
import TestRefactor.RefactorClass;
import TestSerializable.*;
import TestThread.ThreadTest;

/**
 * Created by panting1 on 2017/8/5.
 */
public class mainApp {
    public static void main(String[] args) {
        //序列化测试
        TestSerializable testSerializable = new TestSerializable();
        TestExternalSerialize testExternalSerialize = new TestExternalSerialize();
        try {
            testSerializable.run();
            testExternalSerialize.run();
        }catch (Exception e){
            System.out.println(e.toString());
        }

        //接口测试
        System.out.println();
        InterfaceOneImpl interfaceOne = new InterfaceOneImpl();
        InterfaceTest interfaceTest = new InterfaceTest();
        interfaceTest.run(interfaceOne);

        //线程测试
        System.out.println();
        ThreadTest threadTest = new ThreadTest();
        threadTest.run();

        //反射测试
        System.out.println();
        try {
            RefactorClass.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
