package presenter;

import interfaces.PresenterInterface;
import model.File;
import model.Person;
import view.MainView;

import java.util.List;

public class Presenter implements PresenterInterface {
    private MainView view;
    private File fileModel;

    public Presenter() {
        this.view = new MainView();
        this.fileModel = new File();
    }

    public void run() {
        view.setVisible(true);
    }

    @Override
    public boolean addPerson(String name, String lastName, String age, String salary, String id) {
        boolean canAdd = true;
        try {
            int parseAge = Integer.parseInt(age);
            int parseSalary = Integer.parseInt(salary);
            fileModel.addPersonToFile(new Person(name, lastName, parseAge, parseSalary, id));
            view.showAcceptMessage("Persona agregada exitosamente.");
        } catch (Exception e) {
            view.showErrorMessage("No se pudo agregar la persona, por favor revise los datos ingresados.");
            canAdd = false;
        }
        return canAdd;
    }

    @Override
    public String showAllPersons() {
        List<Person> persons = fileModel.getAllPersons();
        StringBuilder allPersons = new StringBuilder();

        for (Person person : persons) {
            allPersons.append(person.toString()).append("\n");
        }

        return allPersons.toString();
    }

    @Override
    public void searchPersonById(String id) {
        Person person = fileModel.searchPersonInFile(id);
        if (person != null) {
            view.showAcceptMessage("Persona encontrada:\n" + person.toString());
        } else {
            view.showErrorMessage("La persona con la cédula " + id + " no fue encontrada");
        }
    }
}
