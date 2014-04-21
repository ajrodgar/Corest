package lackofcohesioninmethods;

import java.io.*;


public class LackOfCohesionMeter {
    
    public static void print(File file){
        System.out.println(FileStringizer.fileToString(file));
    }    

    public static int countMethodsInClass(File file) {
        String stringFile=FileStringizer.fileToString(file);
        
        return stringFile.split("\\) \\{").length;
    }
    
}
