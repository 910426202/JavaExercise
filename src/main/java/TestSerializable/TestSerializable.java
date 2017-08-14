package TestSerializable;

import java.io.*;

/**
 * Created by panting1 on 2017/8/5.
 */
public class TestSerializable {
    public void run() throws IOException, ClassNotFoundException {
        SerializableImpl serializable = new SerializableImpl();
        serializable.setName("Lilei");
        serializable.setAge(15);

        //创建一个对象输出流，讲对象输出到文件,FileOutputStream会自动创建文件
//        File.mkdirs();//创建目录
//        File fp = new File("1.txt");
//        if (!fp.exists()) {
//            try
//            {
//                fp.createNewFile();
//            }catch (IOException e){
//                System.out.println(e.toString());
//            }
//        }
        System.out.println(serializable);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("1.txt"));
        out.writeObject(serializable);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("1.txt"));
        SerializableImpl serializable2 = (SerializableImpl)in.readObject();
        System.out.println(serializable2);
    }
}
