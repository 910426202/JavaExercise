package TestSerializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 继承了Serializable即可支持序列化
 * 通过重写readobject和writeobject实现个性化序列化
 * Created by panting1 on 2017/8/5.
 */
public class SerializableImpl implements Serializable {
    //继承readobject和writeobject
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SerializableImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("实现个性化序列化输出:name=" + name + " age="+age);
        out.writeObject("+ " + name);
        out.writeObject(age+10);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.name = (String)in.readObject();
        this.age  = (Integer)in.readObject();
        System.out.println("实现个性化序列化输入:name=" + name + " age=" +age);
    }
}
