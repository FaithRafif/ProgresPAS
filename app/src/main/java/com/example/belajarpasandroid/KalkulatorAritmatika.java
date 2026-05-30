package com.example.belajarpasandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KalkulatorAritmatika extends AppCompatActivity implements View.OnClickListener {
    EditText EdPertama,EdKedua;
    Button Btnkali,Btnbagi,Btnkurang,Btntambah;
    TextView TvHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_kalkulator_aritmatika);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
       EdPertama = findViewById(R.id.angkaPertama);
       EdKedua = findViewById(R.id.angkaKedua);
       Btnkali = findViewById(R.id.BtnKali);
       Btnbagi = findViewById(R.id.BtnBagi);
       Btnkurang = findViewById(R.id.BtnKurang);
       Btntambah = findViewById(R.id.BtnTambah);
       TvHasil = findViewById(R.id.TvHasil);
      Btnkali.setOnClickListener(this);
      Btnbagi.setOnClickListener(this);
      Btnkurang.setOnClickListener(this);
      Btntambah.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String input1 = EdPertama.getText().toString().trim();
        String input2 = EdKedua.getText().toString().trim();

        if (input1.isEmpty() || input2.isEmpty())
        {
            Toast.makeText(this,"Angka tidak boleh kosong",Toast.LENGTH_SHORT).show();
            return;
        }
        // Konversi ke angka
        double angka1 = Double.parseDouble(input1);
        double angka2 = Double.parseDouble(input2);
        double hasil = 0;

        // Cek ID tombol mana yang diklik menggunakan if-else atau switch-case
        int idTombol = v.getId();

        if (idTombol == R.id.BtnTambah) {
            hasil = angka1 + angka2;
        } else if (idTombol == R.id.BtnKurang) {
            hasil = angka1 - angka2;
        } else if (idTombol == R.id.BtnKali) {
            hasil = angka1 * angka2;
        } else if (idTombol == R.id.BtnBagi) {
            if (angka2 == 0) {
                TvHasil.setText("Error: Tidak bisa dibagi 0");
                return;
            }
            hasil = angka1 / angka2;
        }


        TvHasil.setText("Hasil: " + hasil);
    }
}