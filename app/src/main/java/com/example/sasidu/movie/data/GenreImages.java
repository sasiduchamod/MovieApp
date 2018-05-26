package com.example.sasidu.movie.data;

public class GenreImages {

    public GenreImages() {
    }

    private static String[] ImageArray = {
            "http://www.filmsite.org/images/action-genre.jpg",
            "http://www.filmsite.org/images/adventure-genre.jpg",
            "http://www.filmsite.org/images/animated-genre.jpg",
            "http://www.filmsite.org/images/comedy-genre.jpg",
            "http://www.filmsite.org/images/crime-genre.jpg",
            "http://www.filmsite.org/images/documentary-genre.jpg",
            "http://www.filmsite.org/images/drama-genre.jpg",
            "http://www.filmsite.org/images/childrens-family-genre.jpg",
            "http://www.filmsite.org/images/fantasy-genre.jpg",
            "http://www.filmsite.org/images/epics-genre.jpg",
            "http://www.filmsite.org/images/horror-genre.jpg",
            "http://www.filmsite.org/images/musicals-genre.jpg",
            "http://www.filmsite.org/images/detective-genre.jpg",
            "http://www.filmsite.org/images/romance-genre.jpg",
            "http://www.filmsite.org/images/scifi-genre.jpg",
            "http://www.filmsite.org/images/comedy-genre.jpg",
            "http://www.filmsite.org/images/thriller-genre.jpg",
            "http://www.filmsite.org/images/war-genre.jpg",
            "http://www.filmsite.org/images/westerns-genre.jpg"

    };

    public static String getGenreImage(int imageNumber){

        return ImageArray[imageNumber];
    }
}

