package com.pojo;

import java.util.Objects;

/**
 * @code Description
 * @code author 本当迷
 * @code date 2022/7/26-17:03
 */
public class User {
    private String name;
    private String password;
    private String type;
    private int id;
    private String admin;

    public User() {
    }


    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public User(String userName, String password) {
        this.name = userName;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdmin() {
        return admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String userName) {
        this.name = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, type);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", id=" + id +
                ", admin='" + admin + '\'' +
                '}';
    }
}
