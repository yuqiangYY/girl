package com.imooc.demo.eneity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity //表明类Girl对应数据库里面的一个表
public class Girl {
    @Id
    @GeneratedValue//Id一般都用作自增的。
    private Integer id;

    private String cupSize;//罩杯

    @Min(value = 18,message = "未成年禁止入内")
    private Integer age;
    // 必须要选一个无参的构造方法，不然待会数据库操作的时候会报错
    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}