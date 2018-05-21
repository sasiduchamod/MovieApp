package com.example.sasidu.movie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sasidu.movie.Adapters.GenreAdapter;
import com.example.sasidu.movie.Models.Genre;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.sasidu.movie.Util.Constants.API_KEY;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private GenreAdapter mGenreAdapter;
    private ArrayList<Genre> mExampleList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mExampleList = new ArrayList<>();
        mRequestQueue = Volley.newRequestQueue(this);
        parseJson();
    }

    private void parseJson(){

        String url = "https://api.themoviedb.org/3/genre/movie/list?api_key="+API_KEY+"&language=en-US";

        JsonObjectRequest request  = new JsonObjectRequest(Request.Method.GET, url, null
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("genres");
                    for (int i = 0; i <jsonArray.length(); i++ )
                    {
                        JSONObject gen = jsonArray.getJSONObject(i);

                        String id = gen.getString("id");
                        String Name = gen.getString("name");

                        mExampleList.add(new Genre(Name, id));
                    }

                    mGenreAdapter = new GenreAdapter(MainActivity.this,mExampleList);
                    mRecyclerView.setAdapter(mGenreAdapter);

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
