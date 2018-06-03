package com.example.sasidu.movie.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sasidu.movie.Models.Actors;
import com.example.sasidu.movie.R;
import com.example.sasidu.movie.Util.Constants;
import com.squareup.picasso.Picasso;


import java.util.List;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.MyViewHolder>{

    private Context mContext;
    private List<Actors> mData;

    public ActorAdapter(Context mContext, List<Actors> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInfalter = LayoutInflater.from(mContext);
        view =mInfalter.inflate(R.layout.acotors, parent,false);
        return new ActorAdapter.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Actors currentItem = mData.get(position);

        holder.cName.setText(currentItem.getCname());
        holder.Name.setText(currentItem.getName());

        Picasso.with(mContext)
                .load(Constants.IMAGE_BASE_URL+currentItem.getPpath())
                .into(holder.profilepath);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{


        ImageView profilepath;
        TextView cName;
        TextView Name;
        CardView genreCard;

         public MyViewHolder(View itemView) {
             super(itemView);

             profilepath = (ImageView) itemView.findViewById(R.id.p_path);
             cName = (TextView) itemView.findViewById(R.id.charactor_name);
             Name = (TextView) itemView.findViewById(R.id.name);
             genreCard = itemView.findViewById(R.id.actorCardView);


         }
     }

}
