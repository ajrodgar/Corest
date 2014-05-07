package lackofcohesioninmethods;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        //System.out.println(LackOfCohesionMeter.lackOfCohesion(FileStringizer.fileToString(new File("GitRepository.java"))));
        for (String att : LackOfCohesionMeter.extractAttributeLines(FileStringizer.fileToString(new File("simpleClass.txt")))) {
            System.out.println(att);
        }
        
    }
    
   
}
