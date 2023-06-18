package com.example.book_reading_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.book_reading_app.R;

public class MainActivity extends AppCompatActivity {

    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test = findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent it = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(it);*/

                LoginActivity customDialog = new LoginActivity(MainActivity.this, R.style.CustomDialogTheme);
                customDialog.show();
            }
        });



    }



}