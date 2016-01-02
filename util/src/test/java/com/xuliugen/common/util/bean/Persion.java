package com.xuliugen.common.util.bean;

/**
 * Created by xuliugen on 16/1/2.
 */
public class Persion {

    private String name;
    private String password;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Persion{");
        sb.append("name='").append(name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", sex='").append(sex).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
