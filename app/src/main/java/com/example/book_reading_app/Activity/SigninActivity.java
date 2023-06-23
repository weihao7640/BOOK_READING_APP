package com.example.book_reading_app.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.UserManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.book_reading_app.API.APIService;
import com.example.book_reading_app.API.RetrofitClient;
import com.example.book_reading_app.API.constants;
import com.example.book_reading_app.Model.UserModel;
import com.example.book_reading_app.R;
import com.example.book_reading_app.Util.MaHoa;
import com.google.android.material.snackbar.Snackbar;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SigninActivity extends AppCompatActivity {

    APIService apiService;
    TextView test;
    TextView username, fullname, emaill, password, repassword;
    EditText birthday;
    Boolean gender;
    RadioButton radio_nam, radio_nu;
    RadioGroup radioGroup;
    CheckBox check_thoathuan;
    Button button_next;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        AnhXa();
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignIn();
            }
        });



    }

    public void SignIn(){
        String UsernamString= username.getText().toString();
        String FullnameString= fullname.getText().toString();
        String EmailString=emaill.getText().toString();
        String PasswordString= password.getText().toString();
        String RePasswordString=repassword.getText().toString();
        String BirthdayString = birthday.getText().toString();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.radio_nam)
                {
                    gender=true;
                }
                else if (i==R.id.radio_nu){
                    gender=false;
                }
            }
        });


        if(TextUtils.isEmpty(UsernamString)){
            username.setError("Nhập thiếu username rùi nè!");
            username.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(FullnameString)){
            fullname.setError("Người vô danh chăng?");
            fullname.requestFocus();
            return;
        }
        if(radio_nam.isChecked()==false && radio_nu.isChecked()==false){

            radio_nam.setError("Báo cáo app lỗi về giới tính? Không còn giới tính nào để chọn?");
            radio_nam.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(EmailString)){
            emaill.setError("Tạo acc clone hay gì mà không nhập emaill! Hã? Hã? Sao không nhập hã?");
            emaill.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(BirthdayString)){
            birthday.setError("Khó khai lắm hả? Chưa được đẻ ra?");
            birthday.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(PasswordString)){
            password.setError("Tạo acc công cộng à?");
            password.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(RePasswordString)){
            repassword.setError("Nhập lại thui mà củng làm biếng!");
            repassword.requestFocus();
            return;
        }
        if (check_thoathuan.isChecked()==false)
        {
            check_thoathuan.setError("Không đồng ý chính sách của t mà đòi đăng ký sao?");
            check_thoathuan.requestFocus();
            return;
        }
        if (PasswordString.equals(RePasswordString)){

            PasswordString= MaHoa.toSHA1(PasswordString);
            UserModel u=new UserModel();
            u.setUsername_user(UsernamString);
            u.setFullname_user(FullnameString);
            u.setEmail_user(EmailString);
            u.setHash_password_user(PasswordString);
            u.setSalt_user("asjrlkmcoewj@tjle;oxqskjhdjksjf1jurVn");
            u.setAvatar_user(null);
            u.setCreated_date_user(null);
            u.setUpdated_date_user(null);
            u.setIs_actived_user(true);
            u.setIs_hiden_user(false);
            u.setIs_active_email_user(false);
            u.setIs_active_phone_user(false);
            u.setPhone_user(null);
            if (radio_nam.isChecked()==true){u.setGender_user(true);}
            else {u.setGender_user(false);}

            u.setBirthday_user(null);
            apiService= RetrofitClient.getInstance().getRetrofit(constants.ROOT_URL).create(APIService.class);
            apiService.SignIn(u).enqueue(new Callback<UserModel>() {
                @Override
                public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                    Toast.makeText(SigninActivity.this, "Đã tạo tài khoản thành công gòi nha", Toast.LENGTH_SHORT).show();
                    Intent it=new Intent(SigninActivity.this, MainActivity.class);
                    startActivity(it);
                }

                @Override
                public void onFailure(Call<UserModel> call, Throwable t) {

                }
            });

        }
        else {
            repassword.setError("Nhập lại mật khẩu có giống đâu mà đòi đăng ký!");
            repassword.requestFocus();
        }




    }

    public void AnhXa(){
        username = findViewById(R.id.edit_username);
        fullname=findViewById(R.id.edit_fullname);
        emaill=findViewById(R.id.edit_email);
        password=findViewById(R.id.edit_password);
        repassword=findViewById(R.id.edit_rePassword);
        birthday=findViewById(R.id.edit_birthday);
        radio_nam=findViewById(R.id.radio_nam);
        radio_nu=findViewById(R.id.radio_nu);
        radioGroup=findViewById(R.id.radionGroup);
        button_next=findViewById(R.id.btn_next);
        check_thoathuan=findViewById(R.id.checkbox_thoathuan);
    }

}