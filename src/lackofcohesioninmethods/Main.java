
package lackofcohesioninmethods;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("SimpleClass.txt");
        System.out.println(LackOfCohesionMeter.lackOfCohesion(file));
    }
}
