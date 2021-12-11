package com.assignmentss.safehouse.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.assignmentss.safehouse.data.remote.model.CharacterResponseItem;
import com.assignmentss.safehouse.data.remote.repo.AppRepository;

import java.util.List;

public class AppViewModel extends AndroidViewModel {

    private final AppRepository appRepository;


    public AppViewModel(@NonNull Application application) {
        super(application);
        this.appRepository = new AppRepository(application.getApplicationContext());
    }

    public MutableLiveData<List<CharacterResponseItem>> GetCharacters(){
        return appRepository.GetCharacters();
    }
}
