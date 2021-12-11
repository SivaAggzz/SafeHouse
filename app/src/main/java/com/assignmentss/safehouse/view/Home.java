package com.assignmentss.safehouse.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.assignmentss.safehouse.R;
import com.assignmentss.safehouse.data.remote.model.CharacterResponseItem;
import com.assignmentss.safehouse.databinding.HomeBinding;
import com.assignmentss.safehouse.view.adapter.CharacterAdapter;
import com.assignmentss.safehouse.viewmodel.AppViewModel;

import java.util.List;
import java.util.Objects;

public class Home extends AppCompatActivity {
    private HomeBinding homeBinding;
    private AppViewModel appViewModel;
    private CharacterAdapter characterAdapter;


    private final Observer<List<CharacterResponseItem>> characterDataObs=new Observer<List<CharacterResponseItem>>() {
        @Override
        public void onChanged(List<CharacterResponseItem> characterResponseItems) {
            if (characterResponseItems!=null) {
                setAdapterData(characterResponseItems);
            }
            appViewModel.GetCharacters().removeObserver(characterDataObs);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).setTitle(getString(R.string.app_name));
        homeBinding=DataBindingUtil.setContentView(this, R.layout.home);
        appViewModel= ViewModelProviders.of(this).get(AppViewModel.class);
        initViews();
    }

    private void initViews() {
        appViewModel.GetCharacters().observe(this, characterDataObs);
    }

    private void setAdapterData(List<CharacterResponseItem> response) {
        characterAdapter=new CharacterAdapter(this,response);
        homeBinding.recyclerView.setAdapter(characterAdapter);
    }
}