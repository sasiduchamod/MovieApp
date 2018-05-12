package com.example.sasidu.movie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sasidu.movie.data.GenreImages;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter <ExampleAdapter.ExampleViewHolder>{

    private Context mContext;
    private ArrayList<exampletemp> mExamoleList;


    public ExampleAdapter(Context context, ArrayList<exampletemp> exampleList)
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

        exampletemp currentItem = mExamoleList.get(position);
        Picasso.with(mContext)
                .load(GenreImages.getGenreImage(position))
                .into(holder.genreImage);
        String id = currentItem.getId();
        String Name = currentItem.getName();
        holder.mId.setText(id);
        holder.mName.setText(Name);
        }

    @Override
    public int getItemCount() {
        return mExamoleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder{

        public TextView mId;
        public TextView mName;
        ImageView genreImage;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            mId = itemView.findViewById(R.id.text_view_id);
            mName = itemView.findViewById(R.id.text_view_name);
            genreImage = itemView.findViewById(R.id.image_view);

        }
    }
}
