package lackofcohesioninmethods;

import java.io.File;
import java.util.ArrayList;

public class LackOfCohesionMeter {

    public static int countMethods(File file) {
        return getMethods(file).size();
    }
   
    private static boolean isMethodLine(String line) {
        line = line.trim().replace(" ", "");
        if (line.startsWith("if(") || line.startsWith("for(") || line.startsWith("while(") || line.startsWith("switch(") || line.startsWith("catch("))
            return false;
        return line.contains("){") || line.contains(")throws");
    }

    private static ArrayList<String> extractAttributeLines(File file) {
        ArrayList<String> attributes = new ArrayList<>();
        int openedBlocks = 0;
        for (String line : FileStringizer.prepareFile(file)) {
            if (line.contains("{")) openedBlocks++;
            else if (line.contains("}")) openedBlocks--;
            else if (openedBlocks == 1 && line.length() > 0) attributes.add(line);
        }
        return attributes; 
    }
    
    public static int countAttributes(File file){
        return extractAttributeLines(file).size();
    }
    
    public static ArrayList<String> identifyAttributeNames(File file) {
        ArrayList<String> attributes = new ArrayList<>();
        for (String line : extractAttributeLines(file)) {
            if (line.contains("=")) attributes.add(getInitializedAttributeName(line));
            else attributes.add(getAttributeName(line));
        }
        return attributes;
    }
    
    private static String getInitializedAttributeName(String line){
        String lineWithOutEqual = line.substring(0, line.indexOf("=")).trim();
        return lineWithOutEqual.substring(lineWithOutEqual.lastIndexOf(" ") + 1, lineWithOutEqual.trim().length());
    }
    
    private static String getAttributeName(String line){
        return line.substring(line.lastIndexOf(" ") + 1, line.length() - 1);
    }
    
    public static ArrayList<Method> getMethods(File file){
        ArrayList<Method> methods = new ArrayList<>();
        Method method = new Method();
        String body = "";
        int openedBlocks = 0;
        
        for (String line : FileStringizer.prepareFile(file)) {
            if (line.contains("{")) openedBlocks++;
            if (line.contains("}")) openedBlocks--;
            if (line.contains("}") && openedBlocks == 1){
                method.setBody(body);
                methods.add(method);
                method = new Method();
                body = "";
            }
            if (openedBlocks < 2) continue;
            
            if (isMethodLine(line))
                method.setSignature(line.trim());
            else
                body+=line.trim()+"\n";
        }
        return methods;
    }
    
    public static double lackOfCohesion(File file){
        int accesses = 0;
        
         for (Method method : LackOfCohesionMeter.getMethods(file)) {
            for(String attribute : LackOfCohesionMeter.identifyAttributeNames(file)){
                if(method.isAccessing(attribute))
                    accesses++;
            }
         }
         
         return (double)(1 - (double)accesses / (countMethods(file) * countAttributes(file)));
    }
}