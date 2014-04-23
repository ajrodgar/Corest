
package lackofcohesioninmethods;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file=new File("ss.txt");
        String s=FileStringizer.fileToString(file);
        
        System.out.println(FileStringizer.format(s));
        
    }
}
