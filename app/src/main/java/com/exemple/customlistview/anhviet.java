package com.exemple.customlistview;

public class diadanh {
    public int id;
    public String ten;
    public double n;
    public double e;

    public diadanh(int id, String ten, double n, double e) {
        this.id = id;
        this.ten = ten;
        this.n = n;
        this.e = e;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public double getE() {
        return e;
    }

    public void setE(double e) {
        this.e = e;
    }
}
