package com.pojo;

import java.util.Objects;

/**
 * @code Description
 * @code author 本当迷
 * @code date 2022/7/27-11:15
 */
public class Play {
    private int userId; // 用户id
    private int id = 1; // 接口id
    private String name; //接口名称
    private String address; // 接口地址

    public Play() {
    }

    public Play(int userId, String name, String address) {
        this.userId = userId;
        this.name = name;
        this.address = address;
    }

    public Play(int userId, int id, String name, String address) {
        this.userId = userId;
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Play play = (Play) o;
        return userId == play.userId && id == play.id && Objects.equals(name, play.name) && Objects.equals(address, play.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, id, name, address);
    }

    @Override
    public String toString() {
        return "Play{" +
                "userId=" + userId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
