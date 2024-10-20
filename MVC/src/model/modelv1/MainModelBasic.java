package model.modelv1;

import interfaces.ModelInterface;
import interfaces.PresenterInterface;

public class MainModelBasic implements ModelInterface{

    private PresenterInterface presenter;

    @Override
    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
    }
    
}