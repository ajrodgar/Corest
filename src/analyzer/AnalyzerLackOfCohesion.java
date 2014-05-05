package analyzer;

import analyzer.auxiliary.FileStringizer;
import analyzer.auxiliary.Method;
import analyzer.results.AnalyzerResult;
import java.util.ArrayList;


public class AnalyzerLackOfCohesion implements Analyzer{
    private String key;
    private String file;
    private int accesses;

    public static int countMethods(String file) {
        return getMethods(file).size();
    }
   
    private static boolean isMethodLine(String line) {
        line = line.trim().replace(" ", "");
        if (line.startsWith("if(") || line.startsWith("for(") || line.startsWith("while(") || line.startsWith("switch(") || line.startsWith("catch("))
            return false;
        return line.contains("){") || line.contains(")throws");
    }

    private static ArrayList<String> extractAttributeLines(String file) {
        ArrayList<String> attributes = new ArrayList<>();
        int openedBlocks = 0;
        for (String line : FileStringizer.prepareFile(file)) {
            if (line.contains("{")) openedBlocks++;
            else if (line.contains("}")) openedBlocks--;
            else if (openedBlocks == 1 && line.length() >= 1) attributes.add(line);
        }
        return attributes; 
    }
    
    public static int countAttributes(String file){
        return extractAttributeLines(file).size();
    }
    
    public static ArrayList<String> identifyAttributeNames(String file) {
        ArrayList<String> attributes = new ArrayList<>();
        for (String line : extractAttributeLines(file)) {
            line=line.trim();
            if (line.contains("=")) attributes.add(getInitializedAttributeName(line));
            else if(line.length() > 0) attributes.add(getAttributeName(line));
        }
        return attributes;
    }
    
    private static String getInitializedAttributeName(String line){
        String lineWithOutEqual = line.substring(0, line.indexOf("=")).trim();
        return lineWithOutEqual.substring(lineWithOutEqual.lastIndexOf(" ") + 1, lineWithOutEqual.trim().length());
    }
    
    private static String getAttributeName(String line){
        System.out.println("\n -------------"+line+"-----");
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

    public AnalyzerLackOfCohesion(String key, String file) {
        this.key = key;
        this.file = file;
        this.accesses = 0;
    }
    
    @Override
    public AnalyzerResult getResult() {
         accesses = 0;
        
         for (Method method : AnalyzerLackOfCohesion.getMethods(file)) {
            for(String attribute : AnalyzerLackOfCohesion.identifyAttributeNames(file)){
                if(method.isAccessing(attribute))
                    accesses++;
            }
         }
         
         double res= (double)(1 - (double)accesses / (countMethods(file) * countAttributes(file)));
         
         return new AnalyzerResult("LackOfCohesion", key, res);
    }
}