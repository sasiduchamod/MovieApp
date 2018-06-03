package com.example.sasidu.movie.Models;

public class Actors {

    private String id;
    private String Ppath;
    private  String Cname;
    private  String Name;

    public Actors(String id, String ppath, String cname, String name) {
        this.id = id;
        Ppath = ppath;
        Cname = cname;
        Name = name;
    }

    public String getId() {
        return id;
    }

    public String getPpath() {
        return Ppath;
    }

    public String getCname() {
        return Cname;
    }

    public String getName() {
        return Name;
    }
}
