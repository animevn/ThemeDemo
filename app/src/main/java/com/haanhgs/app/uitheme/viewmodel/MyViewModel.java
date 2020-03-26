package com.haanhgs.app.uitheme.viewmodel;

import android.app.Application;
import com.haanhgs.app.uitheme.model.Model;
import com.haanhgs.app.uitheme.model.Repo;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class MyViewModel extends AndroidViewModel {

    private final Repo repo;

    public MyViewModel(@NonNull Application application) {
        super(application);
        repo = new Repo();
    }

    public LiveData<Model> getScores(){
        return repo.getLiveData();
    }

    public void increaseA(){
        repo.increaseA();
    }

    public void increaseB(){
        repo.increaseB();
    }

    public void decreaseA(){
        repo.decreaseA();
    }

    public void decreaseB(){
        repo.decreaseB();
    }


}
