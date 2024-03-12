import java.util.*;
import java.lang.Math;

import org.junit.jupiter.api.Test;

public class InputImpl implements InputInterface{

    Scanner scan;

    InputImpl(Scanner s) {
        scan = s;
    }

    public double inputD(String question) {
        System.out.print("    " + question + " ");
        return (scan.nextDouble());
    }

    public int inputI(String question) {
        System.out.print("    " + question + " ");
        return (scan.nextInt());
    }
}
