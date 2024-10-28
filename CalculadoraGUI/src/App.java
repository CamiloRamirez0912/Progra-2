import model.CalculatorModel;
import presenter.CalculatorPresenter;
import view.CalculatorView;

public class App {
    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        new CalculatorPresenter(model, view);
    }
}
