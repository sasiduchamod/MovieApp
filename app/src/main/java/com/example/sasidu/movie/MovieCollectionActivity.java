package com.example.sasidu.movie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sasidu.movie.Adapters.MovieAdapter;
import com.example.sasidu.movie.Models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.sasidu.movie.Util.Constants.API_KEY;

public class MovieCollectionActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MovieAdapter mMovieAdapter;
    private ArrayList<Movie> mExampleList;
    private RequestQueue mRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        mRecyclerView = findViewById(R.id.recycle_id);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        Intent intent = getIntent();
        String genreID = intent.getStringExtra("genreID");
        // st.makeText(this, genreID, Toast.LENGTH_SHORT).show();

        mExampleList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        parseJson(genreID);

    }

    private void parseJson(String genreID){

        String url = "https://api.themoviedb.org/3/genre/"+genreID+"/movies?api_key="+API_KEY+"&language=en-US&include_adult=false&sort_by=created_at.asc";

        JsonObjectRequest request  = new JsonObjectRequest(Request.Method.GET, url, null
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("results");
                    for (int i = 0; i <jsonArray.length(); i++ )
                    {
                        JSONObject gen = jsonArray.getJSONObject(i);

                        String Nsme = gen.getString("original_title");
                        String rating = gen.getString("vote_average");
                        String imgurl = gen.getString("poster_path");
                        String mid = gen.getString("id");


                        mExampleList.add(new Movie(Nsme, imgurl, rating, mid));
                    }

                    mMovieAdapter = new MovieAdapter(MovieCollectionActivity.this,mExampleList);
                    mRecyclerView.setAdapter(mMovieAdapter);

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
}
