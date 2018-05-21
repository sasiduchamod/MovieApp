package com.example.sasidu.movie.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.sasidu.movie.Models.Movie;
import com.example.sasidu.movie.R;
import com.example.sasidu.movie.Util.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter <MovieAdapter.MiViewHolder> {


    private Context mContext;
    private List<Movie> mData;


    public MovieAdapter(Context mContext, List<Movie> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInfalter = LayoutInflater.from(mContext);
        view =mInfalter.inflate(R.layout.singlemovie, parent,false);
        return new MiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MiViewHolder holder, int position) {
        Movie currentItem = mData.get(position);

        holder.movie_tittle.setText(currentItem.getmName());
        holder.rating.setRating(Float.parseFloat(currentItem.getmRating()));
        Picasso.with(mContext)
                .load(Constants.IMAGE_BASE_URL+currentItem.getmUrl())
                .into(holder.imgurl);




    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MiViewHolder extends RecyclerView.ViewHolder{

        TextView movie_tittle;
        ImageView imgurl;
        RatingBar rating;

        public MiViewHolder(View itemView) {
            super(itemView);

            movie_tittle = (TextView) itemView.findViewById(R.id.movie_name);
            imgurl = (ImageView) itemView.findViewById(R.id.image_id);
            rating = (RatingBar) itemView.findViewById(R.id.ratingBar);


        }
    }


}
