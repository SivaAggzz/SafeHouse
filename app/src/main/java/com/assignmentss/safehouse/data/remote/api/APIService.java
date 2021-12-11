package com.assignmentss.safehouse.data.remote.api;

import com.assignmentss.safehouse.data.remote.model.CharacterResponseItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("api/characters/")
    Call<List<CharacterResponseItem>> GetCharacters();


}
