import java.util.*;
import java.lang.Math;

import org.junit.jupiter.api.Test;

public class InputMock implements InputInterface{

    int counter;
    
    public double inputD(String question) {
       switch (counter++) {
        case 0:
            return 3.3;
        case 1:
            return 4.0; 
        default:
            return 0.95;
       }
    }

    public int inputI(String question) {
        switch (counter++) {
            case 0:
                return 3;
            case 1:
                return 4; 
            default:
                return 0;
           }
    }
}
