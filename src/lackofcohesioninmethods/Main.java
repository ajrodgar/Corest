package lackofcohesioninmethods;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //System.out.println(LackOfCohesionMeter.lackOfCohesion(FileStringizer.fileToString(new File("GitRepository.java"))));
        for (String att : LackOfCohesionMeter.identifyAttributeNames(FileStringizer.fileToString(new File("simpleClass.txt")))) {
            System.out.println(att);
        }
        
        for (Method met : LackOfCohesionMeter.getMethods(FileStringizer.fileToString(new File("simpleClass.txt")))) {
            System.out.println("Firma: "+met.getSignature());
            System.out.println("Cuerpo: "+met.getBody());
            System.out.println("Lineas: "+met.getNumberOfLines());
        }
        
    }
    
   
}
