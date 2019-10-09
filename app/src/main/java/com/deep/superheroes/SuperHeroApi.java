package com.deep.superheroes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SuperHeroApi {

    @GET("marvel")
    Call<List<SuperHero>> getHeroes();
}
