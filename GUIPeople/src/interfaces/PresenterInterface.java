package interfaces;

public interface PresenterInterface {
    boolean addPerson(String name, String lastName, String age, String salary, String id);
    String showAllPersons();
    void searchPersonById(String id);
    
}