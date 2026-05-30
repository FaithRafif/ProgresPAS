package com.example.belajarpasandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Tunggu 2 detik, lalu cek status login
        new Handler().postDelayed(() -> {

            SharedPreferences prefs = getSharedPreferences(
                    "MyPrefs", MODE_PRIVATE);
            boolean sudahLogin = prefs.getBoolean(
                    "isLogin", false);

            Intent intent;
            if (sudahLogin) {
                // Langsung ke Home kalau sudah pernah login
                intent = new Intent(this, HomeActivity.class);
            } else {
                intent = new Intent(this, LoginActivity.class);
            }

            startActivity(intent);
            finish(); // tutup splash agar tidak bisa back

        }, 2000); // 2000ms = 2 detik
    }
}