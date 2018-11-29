package cn.dashingqi.com.fragmenttofragment.model;

/**
 * <p>文件描述：<p>
 * <p>作者：北京车车网络技术有限公司<p>
 * <p>创建时间：2018/11/22<p>
 * <p>更改时间：2018/11/22<p>
 * <p>版本号：1<p>
 */
public class Person {
    private String name;
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
