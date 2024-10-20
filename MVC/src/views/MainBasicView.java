package views;

import interfaces.PresenterInterface;
import interfaces.ViewInterface;
import javax.swing.JFrame;

public class MainBasicView extends JFrame implements ViewInterface{

    private PresenterInterface presenter;

    @Override
    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public void run(){
        this.setVisible(true);
    }
    
}
