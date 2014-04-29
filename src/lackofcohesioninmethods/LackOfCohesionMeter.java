package lackofcohesioninmethods;

import java.io.File;
import java.util.ArrayList;

public class LackOfCohesionMeter {
    private static int numberOfMethods = 0;
    
    public static int countMethodsInClass(File file) {
        return numberOfMethods;
    }
   
    private static boolean isMethodLine(String line) {
        line = line.trim();
        if (line.startsWith("if(") || line.startsWith("for(") || line.startsWith("while(") || line.startsWith("switch(") || line.startsWith("catch("))
            return false;
        else if (line.contains("){") || line.contains(")throws"))
            return true;
        return false;
    }

    private static ArrayList<String> getLineAttributes(File file) {
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
        return getLineAttributes(file).size();
    }
    
    public static ArrayList<String> identifyAttributes(File file) {
        ArrayList<String> attributes = new ArrayList<>();
        
        for (String line : getLineAttributes(file)) {
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
        int openedBlocks = 0;
        int attributeAparitions = 0;
        String methodSignature = "";

        for (String line : FileStringizer.prepareFileWithoutSpaces(file)) {
            if (line.contains("{")) openedBlocks++;
            if (line.contains("}")) openedBlocks--;
            if (openedBlocks < 2) continue;
            
            if (isMethodLine(line)){
                methodSignature = getMethodSignature(line);
                numberOfMethods++;
            }
            else {
                for (String attribute : identifyAttributes(file)) {
                    if(isAttributedUsed(attribute, methodSignature, line)) attributeAparitions++;
                }
            }
        }
        return attributeAparitions;
    }
    
    private static String getMethodSignature(String line){
        int start = line.indexOf("(");
        int end = line.indexOf(")");
        return line.substring(start + 1, end);
    }
    
    private static boolean isAttributedUsed(String attribute, String signature, String line){
        if (signature.contains(attribute)) {
            if (line.contains("this." + attribute)) {
                return true;
            }
        } else {
            if (line.contains(attribute)) {
                return true;
            }
        }
        return false;
    }
}
