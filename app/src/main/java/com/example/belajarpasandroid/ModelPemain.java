package com.example.belajarpasandroid;

public class ModelPemain {
    private String nama;
    private String club;
    private String posisi;
    private String rating;
    private String goal;
    private String assist;
    private String perjalananKarir;

    private int gambar;

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public String getClub() {
        return club;
    }

    public String getPosisi() {
        return posisi;
    }

    public String getRating() {
        return rating;
    }

    public String getGoal() {
        return goal;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public void setAssist(String assist) {
        this.assist = assist;
    }

    public void setPerjalananKarir(String perjalananKarir) {
        this.perjalananKarir = perjalananKarir;
    }   

    public String getAssist() {
        return assist;
    }

    public String getPerjalananKarir() {
        return perjalananKarir;
    }

    public ModelPemain(String nama, String club, String posisi, String rating, String goal, String assist, String perjalananKarir,int gambar) {
        this.nama = nama;
        this.club = club;
        this.posisi = posisi;
        this.rating = rating;
        this.goal = goal;
        this.assist = assist;
        this.perjalananKarir = perjalananKarir;
        this.gambar = gambar;
    }
}
