package lackofcohesioninmethods;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String[] code = FileStringizer.prepareFile(new File("simpleClass.txt"));
        for (String string : code) {
            System.out.println(string);
        }
    }
}
