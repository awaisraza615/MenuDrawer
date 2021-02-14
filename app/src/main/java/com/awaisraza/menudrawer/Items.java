package com.awaisraza.menudrawer;

public class Items {

    int picurl;
    String Fname;
    String Lname;

    public Items(int picurl, String fname, String lname) {
        this.picurl = picurl;
        Fname = fname;
        Lname = lname;
    }

    public int getPicurl() {
        return picurl;
    }

    public void setPicurl(int picurl) {
        this.picurl = picurl;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }
}
