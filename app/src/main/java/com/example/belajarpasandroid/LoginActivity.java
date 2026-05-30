package com.example.belajarpasandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    CheckBox cbShowPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin   = findViewById(R.id.btnLogin);
        cbShowPass = findViewById(R.id.cbShowPass);

        cbShowPass.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                etPassword.setTransformationMethod(
                        HideReturnsTransformationMethod.getInstance());
            } else {
                etPassword.setTransformationMethod(
                        PasswordTransformationMethod.getInstance());
            }

            etPassword.setSelection(etPassword.getText().length());
        });
        btnLogin.setOnClickListener(v -> cekLogin());
    }

    private void cekLogin() {
        String user = etUsername.getText().toString().trim();
        String pass = etPassword.getText().toString().trim();

        // Validasi tidak boleh kosong
        if (user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this,
                    "Isi username dan password!",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        // Cek username & password (hardcode)
        if (user.equals("admin") && pass.equals("1234")) {

            // Simpan status login ke SharedPreferences
            SharedPreferences prefs = getSharedPreferences(
                    "MyPrefs", MODE_PRIVATE);
            prefs.edit()
                    .putBoolean("isLogin", true)
                    .putString("namaUser", user)
                    .apply();

            startActivity(new Intent(this,
                    HomeActivity.class));
            finish();
        } else {
            Toast.makeText(this,
                    "Username atau password salah!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}