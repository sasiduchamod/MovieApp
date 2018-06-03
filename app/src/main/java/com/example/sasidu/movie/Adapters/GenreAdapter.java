package com.example.sasidu.movie.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sasidu.movie.MovieCollectionActivity;
import com.example.sasidu.movie.Models.Genre;
import com.example.sasidu.movie.R;
import com.example.sasidu.movie.data.GenreImages;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GenreAdapter extends RecyclerView.Adapter <GenreAdapter.ExampleViewHolder>{

    private Context mContext;
    private ArrayList<Genre> mExamoleList;


    public GenreAdapter(Context context, ArrayList<Genre> exampleList)
    {
        mContext = context;
        mExamoleList = exampleList;

    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent,false);
      return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {

        final Genre currentItem = mExamoleList.get(position);
        Picasso.with(mContext)
                .load(GenreImages.getGenreImage(position))
                .into(holder.genreImage);
        final String id = currentItem.getId();
        String Name = currentItem.getName();
//        holder.mId.setText(id);
//        holder.mName.setText(Name);

        holder.genreCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, MovieCollectionActivity.class);
                intent.putExtra("genreID",currentItem.getId());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mExamoleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder{

//        public TextView mId;
//        public TextView mName;
        ImageView genreImage;
        CardView genreCard;

        public ExampleViewHolder(View itemView) {
            super(itemView);
//            mId = itemView.findViewById(R.id.text_view_id);
//            mName = itemView.findViewById(R.id.text_view_name);
            genreImage = itemView.findViewById(R.id.image_view);
            genreCard = itemView.findViewById(R.id.genreCard);

        }
    }
}
