package com.dw.mybatis.V1.bean;

public class Test {
    private Integer id;

    private Integer nums;

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", nums=" + nums +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    private String name;

    private String gender;

    public Test(Integer id, Integer nums, String name, String gender) {
        this.id = id;
        this.nums = nums;
        this.name = name;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Test() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}