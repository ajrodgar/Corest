
package lackofcohesioninmethods;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        File file=new File("simpleClass2.txt");
        ArrayList<String> attributes = LackOfCohesionMeter.getLineAttributes(file);
        ArrayList<String> att = LackOfCohesionMeter.identifyAttributes(attributes);
        System.out.println(LackOfCohesionMeter.attributeAccess(att, FileStringizer.format(FileStringizer.fileToString(file))));
    }
}
