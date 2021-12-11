package com.assignmentss.safehouse.data.remote.repo;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.assignmentss.safehouse.BuildConfig;
import com.assignmentss.safehouse.data.remote.api.APIService;
import com.assignmentss.safehouse.data.remote.api.RetrofitAPI;
import com.assignmentss.safehouse.data.remote.model.CharacterResponseItem;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class AppRepository {
    private final Context context;
    private final APIService apiService;

    public AppRepository(Context context) {
        this.context = context;
        apiService = RetrofitAPI.getRetrofitApiClass(BuildConfig.SERVER_URL);
    }



    public MutableLiveData<List<CharacterResponseItem>> GetCharacters() {
        MutableLiveData<List<CharacterResponseItem>> characterResponseMutableLiveData = new MutableLiveData<>();
        apiService.GetCharacters()
                .enqueue(new Callback<List<CharacterResponseItem>>() {
                    @Override
                    public void onResponse(@NotNull Call<List<CharacterResponseItem>> call, @NotNull Response<List<CharacterResponseItem>> response) {
                        Timber.tag("GetCharacters").e("onResponse+ _%s", response.toString());
                        characterResponseMutableLiveData.setValue(response.body());
                    }

                    @Override
                    public void onFailure(@NotNull Call<List<CharacterResponseItem>> call, @NotNull Throwable t) {
                        Timber.tag("GetCharacters").e("onFailure+ _%s", t.toString());
                        characterResponseMutableLiveData.setValue(null);
                    }
                });
        return characterResponseMutableLiveData;
    }
}
