package com.example.book_reading_app.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.book_reading_app.R;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_app);


        new    Thread(new Runnable() {

            public void run () {
                int n = 0;
                try {
                    do {
                        if (n >= 2000) {
                            IntroActivity.this.finish();
                            Intent it = new Intent(IntroActivity.this.getApplicationContext(), (Class) MainActivity.class);
                            IntroActivity.this.startActivity(it);
                            return;
                        }
                        Thread.sleep((long) 100);
                        n += 100;
                    }
                    while (true);
                } catch (InterruptedException interruptedException) {
                    IntroActivity.this.finish();
                    Intent it = new Intent(IntroActivity.this.getApplicationContext(), (Class) MainActivity.class);
                    IntroActivity.this.startActivity(it);
                    return;
                } catch (Throwable throwable) {
                    IntroActivity.this.finish();
                    Intent it = new Intent(IntroActivity.this.getApplicationContext(), (Class) MainActivity.class);
                    IntroActivity.this.startActivity(it);
                    throw throwable;
                }
            }
        }).

                start();
    }
}