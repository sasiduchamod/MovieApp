package com.example.sasidu.movie.Models;

public class Genre {

    private String mName;
    private  String mId;


    public Genre(String name, String id)
    {
        mName= name;
        mId = id;
    }

    public String getId(){

        return mId;
    }

    public String getName(){

        return mName;
    }


}
