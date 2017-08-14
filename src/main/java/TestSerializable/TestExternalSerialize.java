package TestSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by panting1 on 2017/8/5.
 */
public class TestExternalSerialize {
    public void run(){
        try{
            ExternalSerializeImpl externalSerialize = new ExternalSerializeImpl();
            externalSerialize.setName("HanMeimei");
            externalSerialize.setAge(14);

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("2.txt"));
            out.writeObject(externalSerialize);

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("2.txt"));
            ExternalSerializeImpl externalSerialize1 = (ExternalSerializeImpl)in.readObject();

        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
