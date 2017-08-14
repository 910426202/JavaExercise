package TestClass;

/**
 * 供反射分析的类
 * Created by panting1 on 2017/8/14.
 */
public class UnderAnalyzeClass {
    public UnderAnalyzeClass(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public UnderAnalyzeClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    private String name;

    public Integer age;
}
