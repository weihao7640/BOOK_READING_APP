package com.example.book_reading_app.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.book_reading_app.API.APIService;
import com.example.book_reading_app.API.RetrofitClient;
import com.example.book_reading_app.API.constants;
import com.example.book_reading_app.Model.UserModel;
import com.example.book_reading_app.Pref.SharePrefManager;
import com.example.book_reading_app.R;
import com.example.book_reading_app.Util.MaHoa;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends Dialog {

    APIService apiService;
    EditText Username;
    EditText Password;
    Button Login;
    TextView signin;

    private Context context;

    public LoginActivity(@NonNull Context context, int style) {
        super(context, style);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
            AnhXa();

            Login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    LoginApp();

                }
            });



    }


    private void LoginApp(){
        String usernameString=Username.getText().toString();
        String passwordString=Password.getText().toString();
        if (TextUtils.isEmpty(usernameString)) {
            Username.setError("Ăn cơm có quên không?");
            Username.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(passwordString)) {
            Password.setError("Hết nói nổi!");
            Password.requestFocus();
            return;
        }

        Log.d("loggs", "userLogin: " + constants.ROOT_URL+constants.LOGIN);
        apiService = RetrofitClient.getInstance().getRetrofit(constants.ROOT_URL).create(APIService.class);
        passwordString= MaHoa.toSHA1(passwordString);
        apiService.login(usernameString,passwordString).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                try {
                    if (response.isSuccessful()){
                        UserModel userModel=response.body();
                        UserModel user=new UserModel(
                                userModel.getId_user(),
                                userModel.getFullname_user(),
                                userModel.getPhone_user(),
                                userModel.getEmail_user(),
                                userModel.getAvatar_user(),
                                userModel.getHash_password_user(),
                                userModel.getSalt_user(),
                                userModel.getUsername_user(),
                                userModel.getBirthday_user(),
                                userModel.getGender_user(),
                                userModel.getIs_active_phone_user(),
                                userModel.getIs_active_email_user(),
                                userModel.getIs_actived_user(),
                                userModel.getIs_hiden_user(),
                                userModel.getCreated_date_user(),
                                userModel.getUpdated_date_user()

                        );
                        SharePrefManager.getInstance(getContext().getApplicationContext()).userLogin(user);
                        dismiss();
                        Intent it = new Intent(context,MainActivity.class);
                        context.startActivity(it);

                    }
                }
                catch ( Exception e){

                }
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        });



    }


    public void AnhXa(){
        Username=findViewById(R.id.edit_un);
        Password=findViewById(R.id.edit_pw);
        Login=findViewById(R.id.btn_login);
        signin=findViewById(R.id.tv_signin);

    }


}