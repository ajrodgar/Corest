
package lackofcohesioninmethods;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        File file=new File("simpleClass.txt");
        ArrayList<String> attributes = LackOfCohesionMeter.getLineAttributes(file);
        ArrayList<String> att = LackOfCohesionMeter.identifyAttributes(attributes);
    }
}
