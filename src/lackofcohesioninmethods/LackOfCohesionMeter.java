package lackofcohesioninmethods;

import java.io.*;


public class LackOfCohesionMeter {
    
    public static void print(File file){
        System.out.println(FileStringizer.fileToString(file));
    }    

    public static int countMethodsInClass(File file) {
        String stringFile=FileStringizer.fileToString(file);
        stringFile=stringFile.replace(" ","");
        int exceptionMethods= stringFile.split("\\)throws").length - 1;
        return (stringFile.split("\\)\\{").length - 1)+exceptionMethods;
    }    
    
    
}
