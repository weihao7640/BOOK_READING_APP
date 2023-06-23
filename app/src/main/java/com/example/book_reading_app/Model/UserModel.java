package com.example.book_reading_app.Model;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {
    private int id_user;
private String fullname_user;
private String phone_user;
private String email_user;
private String avatar_user;
private String hash_password_user;
private String salt_user;
private String username_user;
private Date birthday_user;
private Boolean gender_user;
private Boolean is_active_phone_user;
private Boolean is_active_email_user;
private Boolean is_actived_user;
private Boolean is_hiden_user;
private Date created_date_user;
private Date updated_date_user;


    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getFullname_user() {
        return fullname_user;
    }

    public void setFullname_user(String fullname_user) {
        this.fullname_user = fullname_user;
    }

    public String getPhone_user() {
        return phone_user;
    }

    public void setPhone_user(String phone_user) {
        this.phone_user = phone_user;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getAvatar_user() {
        return avatar_user;
    }

    public void setAvatar_user(String avatar_user) {
        this.avatar_user = avatar_user;
    }

    public String getHash_password_user() {
        return hash_password_user;
    }

    public void setHash_password_user(String hash_password_user) {
        this.hash_password_user = hash_password_user;
    }

    public String getSalt_user() {
        return salt_user;
    }

    public void setSalt_user(String salt_user) {
        this.salt_user = salt_user;
    }

    public String getUsername_user() {
        return username_user;
    }

    public void setUsername_user(String username_user) {
        this.username_user = username_user;
    }

    public Date getBirthday_user() {
        return birthday_user;
    }

    public void setBirthday_user(Date birthday_user) {
        this.birthday_user = birthday_user;
    }

    public Boolean getGender_user() {
        return gender_user;
    }

    public void setGender_user(Boolean gender_user) {
        this.gender_user = gender_user;
    }

    public Boolean getIs_active_phone_user() {
        return is_active_phone_user;
    }

    public void setIs_active_phone_user(Boolean is_active_phone_user) {
        this.is_active_phone_user = is_active_phone_user;
    }

    public Boolean getIs_active_email_user() {
        return is_active_email_user;
    }

    public void setIs_active_email_user(Boolean is_active_email_user) {
        this.is_active_email_user = is_active_email_user;
    }

    public Boolean getIs_actived_user() {
        return is_actived_user;
    }

    public void setIs_actived_user(Boolean is_actived_user) {
        this.is_actived_user = is_actived_user;
    }

    public Boolean getIs_hiden_user() {
        return is_hiden_user;
    }

    public void setIs_hiden_user(Boolean is_hiden_user) {
        this.is_hiden_user = is_hiden_user;
    }

    public Date getCreated_date_user() {
        return created_date_user;
    }

    public void setCreated_date_user(Date created_date_user) {
        this.created_date_user = created_date_user;
    }

    public Date getUpdated_date_user() {
        return updated_date_user;
    }

    public void setUpdated_date_user(Date updated_date_user) {
        this.updated_date_user = updated_date_user;
    }

    public UserModel(int id_user, String fullname_user, String phone_user, String email_user, String avatar_user, String hash_password_user, String salt_user, String username_user, Date birthday_user, Boolean gender_user, Boolean is_active_phone_user, Boolean is_active_email_user, Boolean is_actived_user, Boolean is_hiden_user, Date created_date_user, Date updated_date_user) {
        this.id_user = id_user;
        this.fullname_user = fullname_user;
        this.phone_user = phone_user;
        this.email_user = email_user;
        this.avatar_user = avatar_user;
        this.hash_password_user = hash_password_user;
        this.salt_user = salt_user;
        this.username_user = username_user;
        this.birthday_user = birthday_user;
        this.gender_user = gender_user;
        this.is_active_phone_user = is_active_phone_user;
        this.is_active_email_user = is_active_email_user;
        this.is_actived_user = is_actived_user;
        this.is_hiden_user = is_hiden_user;
        this.created_date_user = created_date_user;
        this.updated_date_user = updated_date_user;
    }


    public UserModel(){}
}
