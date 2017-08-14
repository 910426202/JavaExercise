package TestSerializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by panting1 on 2017/8/5.
 */
public class ExternalSerializeImpl implements Externalizable {
    private String name;
    private Integer age;

    public String getName() {
        return name;
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

    @Override
    public String toString() {
        return "ExternalSerializeImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException{
        System.out.println("writeExternal: " + name + " " + age);
        out.writeObject("+" + name);
        out.writeObject(age + 10);
    }

    //@SuppressWarnings({"ClassNotFoundException","IOException"})
    @Override
    public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException{
        this.name = (String)in.readObject();
        this.age = (Integer)in.readObject();
        System.out.println("readExternal: " + name + " " + age);
    }
}
