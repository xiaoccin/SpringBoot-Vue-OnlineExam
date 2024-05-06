package com.exam.entity;

import java.util.Objects;

public class Admin {
    private Integer adminId;

    private String adminName;

    private String sex;

    private String tel;

    private String email;

    private String pwd;

    private String cardId;

    private String role;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)return true;
        if (obj instanceof Admin) {
            //强制转换
            Admin admin = (Admin) obj;
            //判断他们的属性值
            if (adminId.equals(admin.adminId) && adminName.equals(admin.adminName)
                && sex.equals(admin.sex) && tel.equals(admin.tel) && email.equals(admin.email)
                && pwd.equals(admin.pwd) && cardId.equals(admin.cardId) && role.equals(admin.role)
            ) {
                return true;
            }
            else return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, adminName, sex, tel, email, pwd, cardId, role);
    }
}