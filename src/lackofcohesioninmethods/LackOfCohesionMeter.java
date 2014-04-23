package lackofcohesioninmethods;

import java.io.*;


public class LackOfCohesionMeter {    
        

    public static int countMethodsInClass(File file) {
        String stringFile=FileStringizer.fileToString(file);
        stringFile = FileStringizer.format(stringFile);
        String[] lines = stringFile.split("\n");
        int numberOfMethods = 0;
        for (String line : lines) {
            numberOfMethods += processLine(line);
        }
        return numberOfMethods;
    }

    private static int processLine(String line) {
        if(line.contains("if") || line.contains("for"))
            return 0;
        if(line.contains("){") || line.contains(")throws"))
            return 1;
        return 0;
    }
}