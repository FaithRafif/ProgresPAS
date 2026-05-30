package com.example.belajarpasandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PemainAdapter adapter;
    List<PemainModel> listPemain;
    Button btnLogout;
    TextView tvSambutan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvSambutan  = findViewById(R.id.tvSambutan);
        recyclerView = findViewById(R.id.recyclerView);
        btnLogout   = findViewById(R.id.btnLogout);

        // Tampilkan nama user dari SharedPreferences
        SharedPreferences prefs = getSharedPreferences(
                "MyPrefs", MODE_PRIVATE);
        String namaUser = prefs.getString("namaUser", "");
        tvSambutan.setText("Halo, " + namaUser + "!");

        loadData();

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));
        adapter = new PemainAdapter(this, listPemain);
        recyclerView.setAdapter(adapter);

        btnLogout.setOnClickListener(v -> logout());
    }

    private void loadData() {
        listPemain = new ArrayList<>();
        // nama, posisi, nomor, klub, info
        listPemain.add(new PemainModel(
                "Lionel Messi", "Penyerang",
                10, "Inter Miami",
                "Pemain terbaik dunia 8x Ballon d'Or"));
        listPemain.add(new PemainModel(
                "Cristiano Ronaldo", "Penyerang",
                7, "Al Nassr",
                "5x Ballon d'Or, pencetak gol terbanyak"));
        listPemain.add(new PemainModel(
                "Erling Haaland", "Penyerang",
                9, "Man City",
                "Mesin gol generasi baru"));
        listPemain.add(new PemainModel(
                "Kylian Mbappe", "Penyerang",
                9, "Real Madrid",
                "Tercepat di dunia, juara Piala Dunia 2018"));
        listPemain.add(new PemainModel(
                "Lamine Yamal", "Sayap Kanan",
                19, "Barcelona",
                "Wonderkid Barcelona, juara Euro 2024"));
    }

    private void logout() {
        getSharedPreferences("MyPrefs", MODE_PRIVATE)
                .edit().clear().apply();
        startActivity(new   Intent(this, LoginActivity.class));
        finish();
    }
}