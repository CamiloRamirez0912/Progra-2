package interfaces;

import java.util.Locale;

public interface PresenterInterface {
    boolean addPerson(String name, String lastName, String age, String salary, String id);
    String showAllPersons();
    void searchPersonById(String id);
    void changeLanguaje(Locale locale);
    String getLanguajeMessage(String key);
}