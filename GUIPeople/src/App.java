import presenter.Presenter;
import view.MainView;

public class App {
    public static void main(String[] args) throws Exception {
        MainView view = new MainView();
        Presenter presenter = new Presenter(view);
        presenter.run();
    }
}
