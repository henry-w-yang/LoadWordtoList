package com.exemple.customlistview;

public class anhviet {
   int id;
   String A;
   String v;

    public anhviet(int id, String a, String v) {
        this.id = id;
        A = a;
        this.v = v;
    }

    public anhviet(String a, String v) {
        A = a;
        this.v = v;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }
}
