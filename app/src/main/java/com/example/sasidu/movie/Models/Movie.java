package com.example.sasidu.movie.Models;

public class Movie {

    private String mName;
    private  String mUrl;
    private  String mRating;

    public Movie(String mName, String mUrl, String mRating) {
        this.mName = mName;
        this.mUrl = mUrl;
        this.mRating = mRating;
    }

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
