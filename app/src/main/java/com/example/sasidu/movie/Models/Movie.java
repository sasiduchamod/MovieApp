package com.example.sasidu.movie.Models;

public class Movie {

    private String mName;
    private  String mUrl;
    private  String mRating;
    private String mId;

    public Movie(String mName, String mUrl, String mRating, String mId) {
        this.mName = mName;
        this.mUrl = mUrl;
        this.mRating = mRating;
        this.mId= mId;

    }

    public String getmId(){return  mId;}

    public String getmName() {
        return mName;
    }

    public String getmUrl() {
        return mUrl;
    }

    public String getmRating() {
        return mRating;
    }
}
