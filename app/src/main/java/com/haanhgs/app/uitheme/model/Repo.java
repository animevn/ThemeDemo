package com.haanhgs.app.uitheme.model;

import androidx.lifecycle.MutableLiveData;

public class Repo {

    private final MutableLiveData<Model> liveData = new MutableLiveData<>();
    private final Model model;

    public Repo() {
        model = new Model();
        liveData.setValue(model);
    }

    public MutableLiveData<Model> getLiveData() {
        return liveData;
    }

    public void increaseA(){
        model.setScoreA(model.getScoreA() + 1);
        liveData.setValue(model);
    }

    public void decreaseA(){
        if (model.getScoreA() > 0){
            model.setScoreA(model.getScoreA() - 1);
            liveData.setValue(model);
        }
    }

    public void increaseB(){
        model.setScoreB(model.getScoreB() + 1);
        liveData.setValue(model);
    }

    public void decreaseB(){
        if (model.getScoreB() > 0){
            model.setScoreB(model.getScoreB() - 1);
            liveData.setValue(model);
        }
    }

}
