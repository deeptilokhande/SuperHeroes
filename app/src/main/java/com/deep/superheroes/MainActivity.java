package com.deep.superheroes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SuperHeroesRecyclerViewAdapter adapter;
    SuperHeroApi superHeroApi;
    ArrayList<SuperHero> superHeroArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //Get reference to recyclerView and set Layout Manager
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Get the data from url using Retrofit and set adapter of recyclerview to this
        //data list created from json arraylist from response of retrofit.
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://simplifiedcoding.net/demos/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        superHeroApi = retrofit.create(SuperHeroApi.class);
        Call<List<SuperHero>> call = superHeroApi.getHeroes();
        call.enqueue(new Callback<List<SuperHero>>() {
            @Override
            public void onResponse(Call<List<SuperHero>> call, Response<List<SuperHero>> response) {
                superHeroArrayList = new ArrayList<>(response.body());
                adapter = new SuperHeroesRecyclerViewAdapter(superHeroArrayList, getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<SuperHero>> call, Throwable t) {

            }
        });


    }


}
