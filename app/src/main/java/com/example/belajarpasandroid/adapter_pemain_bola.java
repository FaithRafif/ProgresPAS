package com.example.belajarpasandroid;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter_pemain_bola extends RecyclerView.Adapter<adapter_pemain_bola.ViewHolder> {
    ArrayList<ModelPemain> listpemain;

    PemainOnclickListener listener;

    @NonNull
    @Override
    public adapter_pemain_bola.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter_pemain_bola,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_pemain_bola.ViewHolder holder, int position) {
    ModelPemain pemain = listpemain.get(position);
    holder.rating.setText(pemain.getRating());
    holder.nama.setText(pemain.getNama());
    holder.itemView.setOnClickListener(v -> {
        listener.OnclickPemain(listpemain.get(position));
    });
    }

    @Override
    public int getItemCount() {
        return listpemain.size();
    }

    public interface PemainOnclickListener {
       void OnclickPemain(ModelPemain pemain);
   }

    public adapter_pemain_bola(ArrayList<ModelPemain> listpemain,PemainOnclickListener listener) {
        this.listener = listener;
        this.listpemain = listpemain;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView rating,nama,club,posisi,goal,assist,perjalanankarir;

        ImageView gambar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rating = itemView.findViewById(R.id.tv_item_rating);
            nama = itemView.findViewById(R.id.tv_item_name);
        }
    }
}