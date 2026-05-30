package com.example.belajarpasandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    EditText EdUser,EdPass;
    Button Btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        EdUser = findViewById(R.id.etUsername);
        EdPass = findViewById(R.id.etPassword);
        Btnlogin = findViewById(R.id.btnLogin);
        Btnlogin.setOnClickListener(v -> logins());
    }
    private void logins (){
        String user = EdUser.getText().toString().trim();
        String pass = EdPass.getText().toString().trim();

        if (user.isEmpty() || pass.isEmpty()){
            Toast.makeText(this,"Tolong isi username atau password",Toast.LENGTH_SHORT).show();
            return ;
        }
        if (user.equals("admin") && pass.equals("admin")){
            Intent pindah = new Intent(login.this, list_pemain_bola.class);
            Toast.makeText(this,"Login Berhasil",Toast.LENGTH_SHORT).show();
            startActivity(pindah);
        }else {
            Toast.makeText(this,
                    "Username atau password salah!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}