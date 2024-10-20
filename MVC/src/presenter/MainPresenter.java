package presenter;

import interfaces.ModelInterface;
import interfaces.PresenterInterface;
import interfaces.ViewInterface;

public class MainPresenter implements PresenterInterface{

    private ViewInterface view;
    private ModelInterface model;

    @Override
    public void setModel(ModelInterface model) {
        this.model = model;
    }

    @Override
    public void setView(ViewInterface view) {
        this.view = view;
    }
    
}
