package cn.dashingqi.com.imitatejdscroll;

/**
 * <p>文件描述：<p>
 * <p>作者：北京车车网络技术有限公司<p>
 * <p>创建时间：2018/12/5<p>
 * <p>更改时间：2018/12/5<p>
 * <p>版本号：1<p>
 */
public class Goods {
    private String name;
    private int id;

    public Goods(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
