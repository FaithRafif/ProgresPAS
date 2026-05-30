package com.example.belajarpasandroid;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PemainAdapter
        extends RecyclerView.Adapter<PemainAdapter.ViewHolder> {

    private Context context;
    private List<PemainModel> listPemain;

    // Constructor menerima context dan list data
    public PemainAdapter(Context context,
                         List<PemainModel> listPemain) {
        this.context    = context;
        this.listPemain = listPemain;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {
        // Inflate layout item_pemain.xml jadi View
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_pemain, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int pos) {
        PemainModel p = listPemain.get(pos);

        // Isi TextView dengan data pemain
        holder.tvNama.setText(p.getNama());
        holder.tvPosisi.setText(p.getPosisi());
        holder.tvNomor.setText("#" + p.getNomorPunggung());

        // Klik item → buka DetailPemainActivity
        holder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context,
                    DetailPemainActivity.class);
            i.putExtra("nama",   p.getNama());
            i.putExtra("posisi", p.getPosisi());
            i.putExtra("nomor",  p.getNomorPunggung());
            i.putExtra("klub",   p.getKlub());
            i.putExtra("info",   p.getInfo());
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() { return listPemain.size(); }

    // ViewHolder — menyimpan referensi ke view agar tidak
    // dicari ulang setiap scroll (lebih efisien)
    public static class ViewHolder
            extends RecyclerView.ViewHolder {
        TextView tvNama, tvPosisi, tvNomor;

        public ViewHolder(View v) {
            super(v);
            tvNama   = v.findViewById(R.id.tvNama);
            tvPosisi = v.findViewById(R.id.tvPosisi);
            tvNomor  = v.findViewById(R.id.tvNomor);
        }
    }
}