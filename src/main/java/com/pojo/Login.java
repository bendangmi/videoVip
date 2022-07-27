package com.pojo;

/**
 * @code Description
 * @code author 本当迷
 * @code date 2022/7/26-19:32
 */
public class Login {
    private String success; // 登录成功返回 1 注册返回0 登录失败返回 -1
    private String admin; // 是否为管理员
    private int id; // 用户id
    private String name; // 用户名

    public Login(String success, String admin, int id, String name) {
        this.success = success;
        this.admin = admin;
        this.id = id;
        this.name = name;
    }

    // 保持登录状态
    public Login(String admin, int id, String name) {
        this.admin = admin;
        this.id = id;
        this.name = name;
    }

    public Login(String success, String admin) {
        this.success = success;
        this.admin = admin;
    }

    public Login(String success, String admin, int id) {
        this.success = success;
        this.admin = admin;
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

    public Login() {
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Login{" +
                "success=" + success +
                ", admin='" + admin + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
