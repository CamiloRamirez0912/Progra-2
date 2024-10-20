package presenter;

import interfaces.ViewInterface;
import model.modelv1.MainModelBasic;
import views.MainBasicView;

public class Runner {

    MainModelBasic model;
    MainPresenter presenter;
    ViewInterface view;
    

    public void start(){
        makeMVC();
        view.run();
    }

    private void makeMVC(){
        model = new MainModelBasic();
        presenter = new MainPresenter();
        // MainBasicView view = new MainBasicView();
        view = new MainBasicView();

        view.setPresenter(presenter);
        model.setPresenter(presenter);
        presenter.setModel(model);
        presenter.setView(view);
    }
}
