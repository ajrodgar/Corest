package corest.cohesion;

import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.Test;

public class CohesionCalculatorTests {
    
    @Test
    public void calculateCohesion() {
        CohesionCalculator calculator = new CohesionCalculator();
        assertEquals(15, calculator.calculate(packageClasses()), 0.001);
    }
    
    private ArrayList<String> packageClasses() {
        ArrayList<String> classes = new ArrayList<>();
        classes.add("");
        classes.add("");
        classes.add("");
        classes.add("");
        return classes;
    }
}
