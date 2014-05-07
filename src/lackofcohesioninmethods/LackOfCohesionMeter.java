package lackofcohesioninmethods;

import java.util.ArrayList;

public class LackOfCohesionMeter {

    public static int countMethods(String file) {
        return getMethods(file).size();
    }
   
    private static boolean isMethodLine(String line) {
        line = line.trim().replace(" ", "");
        if (line.startsWith("if(") || line.startsWith("for(") || line.startsWith("while(") || line.startsWith("switch(") || line.startsWith("catch("))
            return false;
        return line.contains("){") || line.contains(")throws");
    }

    public static ArrayList<String> extractAttributeLines(String file) {
        ArrayList<String> attributes = new ArrayList<>();
        int openedBlocks = 0;
        boolean isArray=false;
        for (String line : FileStringizer.prepareFile(file)) {
            if (line.contains("={") && openedBlocks==1){
                isArray = true;
                attributes.add(line);
            }
            else if (line.contains("{")) openedBlocks++;
            else if (line.contains("}") && !isArray) openedBlocks--;
            else if (line.contains("}") && isArray) isArray=false;
            else if (openedBlocks == 1 && line.length() > 0 && !isArray){
                if(line.contains("//")) line = line.substring(0, line.indexOf("//"));
                if(!line.trim().equals("") && openedBlocks==1){
                    if(!line.startsWith(";")) attributes.add(line);
                }
            }
        }
        return attributes; 
    }
    
    public static int countAttributes(String file){
        return extractAttributeLines(file).size();
    }
    
    public static ArrayList<String> identifyAttributeNames(String file) {
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
    
    public static String getAttributeName(String line){
        return line.substring(line.lastIndexOf(" ") + 1, line.length() - 1);
    }
    
    public static ArrayList<Method> getMethods(String file){
        ArrayList<Method> methods = new ArrayList<>();
        Method method = new Method();
        String body = "";
        int openedBlocks = 0;
        
        for (String line : FileStringizer.prepareFile(file)) {
            if (line.contains("{")) openedBlocks++;
            if (line.contains("}")) openedBlocks--;
            if (line.contains("}") && openedBlocks == 1){
                method.setBody(body);
                if(method.getSignature()!=null){
                    methods.add(method);
                    method = new Method();
                    body = "";
                }
            }
            if (openedBlocks < 2) continue;
            
            if (isMethodLine(line))
                method.setSignature(line.trim());
            else
                body+=line.trim()+"\n";
        }
        return methods;
    }
    
    public static double lackOfCohesion(String file){
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