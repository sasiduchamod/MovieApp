package com.example.sasidu.movie;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sasidu.movie.Adapters.DescriptionAdapter;
import com.example.sasidu.movie.Adapters.MovieAdapter;
import com.example.sasidu.movie.Models.Movie;
import com.example.sasidu.movie.Models.MovieDescription;
import com.example.sasidu.movie.Util.Constants;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.sasidu.movie.Util.Constants.API_KEY;

public class MovieDetailActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private DescriptionAdapter mDescriptionAdapter;
    private ArrayList<MovieDescription> mExampleList;
    private RequestQueue mRequestQueue;
    private ImageView backGround;
    private ImageView mposter;
    private TextView mtittle;
    private RatingBar mvote;
    private TextView moverview;
    private TextView mrdate;
    private TextView mpopularity;
    private TextView mlanguage;
    private TextView mruntime;
    private TextView mrevenue;
    private TextView mvcount;
    private TextView mbudget;
    private ImageButton mbutton;
    private ImageButton mbutton2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        backGround = findViewById(R.id.bd_view);
        mposter = findViewById(R.id.p_view);
        mtittle = findViewById(R.id.movie_title_view);
        mvote = findViewById(R.id.ratingBar_view);
        moverview = findViewById(R.id.overview_view);
        mrdate = findViewById(R.id.rdate);
        mpopularity = findViewById(R.id.popularity_view);
        mlanguage = findViewById(R.id.language_view);
        mruntime = findViewById(R.id.runtime_view);
        mrevenue = findViewById(R.id.revenue_view);
        mvcount = findViewById(R.id.votecount_view);
        mbudget = findViewById(R.id.budget_view);
        mbutton = findViewById(R.id.btn1);
        mbutton2= findViewById(R.id.btn2);

        Intent intent = getIntent();
        String movieID = intent.getStringExtra("id");
//        Toast.makeText(this, movieID, Toast.LENGTH_SHORT).show();

        mExampleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);
        parseJSON(movieID, getApplicationContext());
        parseJSon2(movieID, getApplicationContext());
    }


    private  void  parseJSon2(String movieID, Context applicationContext)
    {
        String url ="https://api.themoviedb.org/3/movie/"+movieID+"/videos?api_key="+API_KEY+"&language=en-US";

        JsonObjectRequest request  = new JsonObjectRequest(Request.Method.GET, url, null
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("results");
                    for (int i = 0; i <1; i++ )
                    {
                        JSONObject gen = jsonArray.getJSONObject(i);

                        if(gen.getString("site").equalsIgnoreCase("YouTube")){

                            final String ykey = gen.getString("key");
                            mbutton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(Constants.YOUTUBE_URL+ykey)));
                                }
                            });
                        }



                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });
        mRequestQueue.add(request);




    }

    private void parseJSON(String movieID, final Context context){


        String url ="https://api.themoviedb.org/3/movie/"+movieID+"?api_key="+API_KEY+"&language=en-US";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                String bckdrp = null;
                String poster = null;
                String tittle = null;
                String rating= null;
                String overview = null;
                String rdate = null;
                String popularity = null;
                String language = null;
                String runtime = null;
                String revenue = null;
                String vcount = null;
                String budget = null;
                String imdbid = null;
                try {
                    bckdrp = response.getString("backdrop_path");
                    poster = response.getString("poster_path");
                    tittle = response.getString("title");
                    rating = response.getString("vote_average");
                    overview = response.getString("overview");
                    rdate = response.getString("release_date");
                    popularity = response.getString("popularity");
                    language = response.getString("spoken_languages");
                    runtime = response.getString("runtime");
                    revenue = response.getString("revenue");
                    vcount = response.getString("vote_count");
                    budget = response.getString("budget");
                    imdbid = response.getString("imdb_id");

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                        Picasso.with(context)
                                .load(Constants.IMAGE_BASE_URL+bckdrp)
                                .into(backGround);
                        Picasso.with(context)
                                 .load(Constants.IMAGE_BASE_URL+poster)
                                 .into(mposter);

                        mtittle.setText(tittle);
                        mvote.setRating(Float.parseFloat(rating));
                        moverview.setText(overview);
                        mrdate.setText(rdate);
                        mpopularity.setText(popularity);
                        mlanguage.setText(language);
                        mruntime.setText(runtime);
                        mrevenue.setText(revenue);
                        mvcount.setText(vcount);
                        mbudget.setText(budget);

                final String finalImdbid = imdbid;
                mbutton2.setOnClickListener(new View.OnClickListener() {
                      @Override
                         public void onClick(View view) {
                        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(Constants.IMDB_URL+ finalImdbid)));
                    }
                });




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });

        mRequestQueue.add(request);

    }
}
