package com.example.belajarpasandroid;

public class PemainModel {


    private String nama;
    private String posisi;
    private int nomorPunggung;
    private String klub;
    private String info;

    // Constructor — cara membuat objek pemain baru
    public PemainModel(String nama, String posisi,int nomorPunggung,String klub, String info) {
        this.nama          = nama;
        this.posisi        = posisi;
        this.nomorPunggung = nomorPunggung;
        this.klub          = klub;
        this.info          = info;
    }

    // Getter — ambil nilai field
    public String getNama()         { return nama; }
    public String getPosisi()       { return posisi; }
    public int    getNomorPunggung() { return nomorPunggung; }
    public String getKlub()         { return klub; }
    public String getInfo()         { return info; }
}
