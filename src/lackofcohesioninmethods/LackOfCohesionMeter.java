package lackofcohesioninmethods;

import java.io.File;
import java.util.ArrayList;

public class LackOfCohesionMeter {
    private static int numberOfMethods = 0;

    public static int countMethodsInClass(File file) {
        attributeAccess(file);
        return numberOfMethods;
    }
   
    private static boolean isMethodLine(String line) {
        line = line.trim();
        line = line.replace(" ", "");
        if (line.startsWith("if(") || line.startsWith("for(") || line.startsWith("while(") || line.startsWith("switch(") || line.startsWith("catch("))
            return false;
        else if (line.contains("){") || line.contains(")throws"))
            return true;
        return false;
    }

    private static ArrayList<String> extractAttributeLines(File file) {
        ArrayList<String> attributes = new ArrayList<>();
        int blockCounter = 0;
        
        for (String line : FileStringizer.prepareFile(file)) {
            if (line.length() == 0) continue;
            if (line.contains("{")) blockCounter++;
            else if (line.contains("}")) blockCounter--;
            else if (blockCounter == 1) attributes.add(line);
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
    
    public static int attributeAccess(File file) {
        numberOfMethods = 0;
        int openedBlocks = 0;
        int attributeAparitions = 0;
        String methodParameters = "";

        for (String line : FileStringizer.prepareFile(file)) {
            if (line.contains("{")) openedBlocks++;
            if (line.contains("}")) openedBlocks--;
            if (openedBlocks < 2) continue;
            
            if (isMethodLine(line)){
                methodParameters = getMethodParameters(line);
                numberOfMethods++;
            }
            else {
                for (String attribute : identifyAttributeNames(file)) {
                    if(isAttributeUsed(attribute, methodParameters, line)) attributeAparitions++;
                }
            }
        }
        return attributeAparitions;
    }
    
    private static String getMethodParameters(String line){
        return line.substring(line.indexOf("(") + 1, line.indexOf(")"));
    }
    
    private static boolean isAttributeUsed(String attribute, String parameters, String line){
        if (attributeIsEqualToParameter(parameters, attribute)) 
            return line.contains("this." + attribute);
        return (line.contains(attribute));
    }
    
    public static double lackOfCohesion(File file){
        int attributeAccess = attributeAccess(file);
        return (double) (1 - (double)attributeAccess / (numberOfMethods * countAttributes(file)));
    }

    private static boolean attributeIsEqualToParameter(String methodParameters, String attribute) {
        String[] parameters = methodParameters.split(",");
        for (String parameter : parameters) {
            if(parameter.substring(parameter.lastIndexOf(" ")+1, parameter.length()).equals(attribute)){
               return true;
            }
        }
        return false;
    }
}