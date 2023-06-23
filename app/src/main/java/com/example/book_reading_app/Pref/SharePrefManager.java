package com.example.book_reading_app.Pref;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.book_reading_app.Activity.LoginActivity;
import com.example.book_reading_app.Model.UserModel;

public class SharePrefManager {
    private static final  String SHARED_PREF_NAME = "volleyregisterlogin";
    private static final String KEY_USERID = "keyuserid";
    private static final String KEY_NAME = "keyname";
    private static final String KEY_EMAIL = "keygmail";
    private static final String KEY_USERNAME="keyusername";
    private static final String KEY_PHONE= "keyphone";
    private static final String KEY_SALT = "keysalt";
    private static final String KEY_HASH_PASSWORD = "keyhashpassword";
    private static final String KEY_IS_ACTIVED="keyisactived";
    private static final String KEY_IS_HIDEN="keyishihen";
    private static final String KEY_IS_ACTIVED_EMAIL="keyisactivedemail";
    private static final String KEY_IS_ACTIVED_PHONE ="keyisactivedphone";
    private static final String KEY_GENDER="keygender";
    private static final String KEY_CREATED_DATE="keycreateddate";
    private static final String KEY_UPDATED_DATE="keyupdateddate";
    private static final String KEY_BIRTHDAY="keybirthday";
    private static final String KEY_ROLE = "keyrole";
    private static final String KEY_AVATAR = "keyavatar";
    private static final String KEY_ponit = "keypoint";

    private static SharePrefManager mInstance;
    private static Context ctx;
    private SharePrefManager(Context context){
        ctx = context;
    }
    public static synchronized SharePrefManager getInstance(Context context){
        if(mInstance ==null){
            mInstance = new SharePrefManager(context);
        }
        return mInstance;
    }

    public int getuserID()
    {
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        return sharedPreferences.getInt("user",0);
    }

    public void userLogin(UserModel user){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(KEY_USERID, user.getId_user());
        editor.putString(KEY_NAME, user.getFullname_user());
        editor.putString(KEY_EMAIL, user.getEmaill_user());
        editor.putString(KEY_PHONE, user.getPhone_user());
        editor.putString(KEY_SALT, user.getSalt_user());
        editor.putString(KEY_HASH_PASSWORD, user.getHash_password_user());
        editor.putString(KEY_AVATAR, user.getAvatar_user());
        editor.putBoolean(KEY_IS_ACTIVED,user.getIs_actived_user());
        editor.putBoolean(KEY_IS_HIDEN,user.getIs_hiden_user());
        editor.putBoolean(KEY_IS_ACTIVED_EMAIL,user.getIs_active_email_user());
        editor.putBoolean(KEY_IS_ACTIVED_PHONE,user.getIs_active_phone_user());
        editor.putString(KEY_BIRTHDAY,user.getBirthday_user().toString());
        editor.putBoolean(KEY_GENDER,user.getGender_user());
        editor.putString(KEY_CREATED_DATE,user.getCreated_date_user().toString());
        editor.putString(KEY_UPDATED_DATE,user.getUpdated_date_user().toString());
        editor.putString(KEY_USERNAME, user.getUsername_user());


        editor.apply();
    }

    public void logout(){
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        ctx.startActivity(new Intent(ctx, LoginActivity.class));
    }
}
