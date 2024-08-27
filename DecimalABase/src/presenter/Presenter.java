package presenter;

import model.*;
import view.*;

public class Presenter {
    private Calculate cal;
    private IoManager io;

    Presenter(){
        cal = new Calculate();
        io = new IoManager();
    }

    public void init(){
        calculateNumbers();
    }

    public void calculateNumbers(){
        String decimalNumber = io.readMssage("Ingrese el número decimal con coma: ");
        int base = io.readInt("Ingrese la base de conversión: ");
        String numberConvert = cal.convertIntegerPartToBase(cal.takeNumber(decimalNumber), base);
        numberConvert += "," + cal.convertDecimalPartToBase(cal.takeDecimalNumber(decimalNumber), base);
        io.showMessage(numberConvert);
    }

    
}


