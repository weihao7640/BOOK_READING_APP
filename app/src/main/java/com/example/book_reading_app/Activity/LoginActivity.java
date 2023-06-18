package com.example.book_reading_app.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.example.book_reading_app.R;

public class LoginActivity extends Dialog {


    public LoginActivity(@NonNull Context context, int style) {
        super(context, style);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



    }
}