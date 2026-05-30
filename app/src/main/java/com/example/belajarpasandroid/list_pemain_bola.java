package com.example.belajarpasandroid;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class list_pemain_bola extends AppCompatActivity {
    RecyclerView Rvlistpemain;

    ArrayList<ModelPemain>listPemain = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_pemain_bola);
        Rvlistpemain = findViewById(R.id.Rvlistpemain);

        listPemain.add(new ModelPemain("sigma","barca","sayap tengah atas bawah","90","12","12","sigma boy skibidi toilet hayyuk",R.drawable.download));
        listPemain.add(new ModelPemain("sigma","barca","sayap tengah atas bawah","90","12","12","sigma boy skibidi toilet hayyuk",R.drawable.download));
        listPemain.add(new ModelPemain("sigma","barca","sayap tengah atas bawah","90","12","2","sigma boy skibidi toilet hayyuk",R.drawable.download));


        adapter_pemain_bola adapter = new adapter_pemain_bola(listPemain,pemain -> {
            Intent detail = new Intent(list_pemain_bola.this,detail_pemain.class);
            startActivity(detail);
        });
        Rvlistpemain.setLayoutManager(new LinearLayoutManager(this));
        Rvlistpemain.setAdapter(adapter);
    }
}