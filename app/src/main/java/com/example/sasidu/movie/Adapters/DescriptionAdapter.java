package com.example.sasidu.movie.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.sasidu.movie.Models.Genre;
import com.example.sasidu.movie.Models.MovieDescription;
import com.example.sasidu.movie.R;
import com.example.sasidu.movie.Util.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DescriptionAdapter extends RecyclerView.Adapter <DescriptionAdapter.ExampleViewHolder> {

    private Context mContext;
    private ArrayList<MovieDescription> mExampleList;

    public DescriptionAdapter(Context context, ArrayList<MovieDescription> exampleList)
    {
        mContext = context;
        mExampleList = exampleList;

    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.activity_movie_detail, parent,false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        MovieDescription currentItem = mExampleList.get(position);

        String bckdrp = currentItem.getmBckdrp();
        String poster = currentItem.getmPoster();
        String tittle = currentItem.getmTittle();
        String ratings= currentItem.getmRatings();
        String overview = currentItem.getmOverview();
        String imdbid = currentItem.getmImdbid();
        String pcompany = currentItem.getmPcompanies();
        String pcountry = currentItem.getmPcountries();
        String releasedate = currentItem.getmReleasedate();
        String popularity = currentItem.getmPopularity();
        String language = currentItem.getmLanguage();
        String runtime = currentItem.getmRuntime();
        String revenue = currentItem.getmRevenue();
        String vcount = currentItem.getmVotecount();
        String budget = currentItem.getmBudget();

        Picasso.with(mContext)
                .load(Constants.IMAGE_BASE_URL+currentItem.getmBckdrp())
                .into(holder.bckdrp);

        Picasso.with(mContext)
                .load(Constants.IMAGE_BASE_URL+currentItem.getmPoster())
                .into(holder.poster);

        holder.tittle.setText("Movie Tittle: "+ tittle);
        holder.ratings.setRating(Float.parseFloat(currentItem.getmRatings()));
        holder.overview.setText("Description: "+ overview);
        holder.imdbid.setText("IMDB ID: "+  imdbid);
        holder.pcompanies.setText("Production Companies: "+ pcompany);
        holder.pcountries.setText("Production Countries: "+ pcountry);
        holder.releasedate.setText("Release Date: "+ releasedate);
        holder.popularity.setText("popularity: "+ popularity);
        holder.language.setText("spoken_languages: "+ language);
        holder.runtime.setText("Run Time: "+ runtime);
        holder.revenue.setText("Revenue: "+ revenue);
        holder.votecount.setText("vote_count: "+ vcount);
        holder.budget.setText("budget: "+ budget);
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView bckdrp;
        public ImageView poster;
        public TextView tittle;
        public RatingBar ratings;
        public TextView overview;
        public TextView imdbid;
        public TextView pcompanies;
        public TextView pcountries;
        public TextView releasedate;
        public TextView popularity;
        public TextView language;
        public TextView runtime;
        public TextView revenue;
        public TextView votecount;
        public TextView budget;


        public ExampleViewHolder(View itemView) {
            super(itemView);

            bckdrp = itemView.findViewById(R.id.bd_view);
            poster = itemView.findViewById(R.id.p_view);
            tittle = itemView.findViewById(R.id.movie_title_view);
            ratings = itemView.findViewById(R.id.ratingBar_view);
//            overview = itemView.findViewById(R.id.overview_view);
//            imdbid = itemView.findViewById(R.id.imdb_view);
//            pcompanies = itemView.findViewById(R.id.pcompanies_view);
//            pcountries = itemView.findViewById(R.id.pcountries_view);
//            releasedate = itemView.findViewById(R.id.releasedate_view);
            popularity = itemView.findViewById(R.id.popularity_view);
            language = itemView.findViewById(R.id.language_view);
            runtime = itemView.findViewById(R.id.runtime_view);
            revenue = itemView.findViewById(R.id.revenue_view);
            votecount = itemView.findViewById(R.id.votecount_view);
            budget = itemView.findViewById(R.id.budget_view);


        }
    }
}
