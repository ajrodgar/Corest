
package lackofcohesioninmethods;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file=new File("simpleClass.txt");
        LackOfCohesionMeter.print(file);
    }
}
