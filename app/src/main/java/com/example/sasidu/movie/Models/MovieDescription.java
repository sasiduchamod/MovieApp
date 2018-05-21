package com.example.sasidu.movie.Models;

public class MovieDescription {

    private String Title;
    private  String Ratings;
    private  String Imgurl;

    public MovieDescription() {
    }

    public MovieDescription(String title, String ratings, String imgurl) {
        Title = title;
        Ratings = ratings;
        Imgurl = imgurl;
    }

    public String getTitle() {
        return Title;
    }

    public String getRatings() {
        return Ratings;
    }

    public String getImgurl() {
        return Imgurl;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setRatings(String ratings) {
        Ratings = ratings;
    }

    public void setImgurl(String imgurl) {
        Imgurl = imgurl;
    }
}
