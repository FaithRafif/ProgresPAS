package com.example.belajarpasandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailPemainActivity extends AppCompatActivity {

    TextView tvNama, tvPosisi, tvNomor, tvKlub, tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemain);

        tvNama   = findViewById(R.id.tvNama);
        tvPosisi = findViewById(R.id.tvPosisi);
        tvNomor  = findViewById(R.id.tvNomor);
        tvKlub   = findViewById(R.id.tvKlub);
        tvInfo   = findViewById(R.id.tvInfo);

        // Ambil data yang dikirim dari Adapter via Intent
        Intent intent = getIntent();
        String nama   = intent.getStringExtra("nama");
        String posisi = intent.getStringExtra("posisi");
        int    nomor  = intent.getIntExtra("nomor", 0);
        String klub   = intent.getStringExtra("klub");
        String info   = intent.getStringExtra("info");

        // Tampilkan ke layar
        tvNama.setText(nama);
        tvPosisi.setText("Posisi : " + posisi);
        tvNomor.setText("Nomor  : #" + nomor);
        tvKlub.setText("Klub   : " + klub);
        tvInfo.setText(info);

        // Tombol back di ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(
                    true);
            getSupportActionBar().setTitle("Detail Pemain");
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish(); // kembali ke Home saat back ditekan
        return true;
    }
}