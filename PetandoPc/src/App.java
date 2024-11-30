import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < 1000000000; i++){
            list.add("abc");
        }
    }


}
