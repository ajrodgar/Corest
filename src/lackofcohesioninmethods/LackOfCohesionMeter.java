package lackofcohesioninmethods;

import java.io.File;
import java.util.ArrayList;

public class LackOfCohesionMeter {

    public static int countMethodsInClass(File file) {
        String stringFile = FileStringizer.format(FileStringizer.fileToString(file));
        stringFile = FileStringizer.deleteSpaces(stringFile);
        String[] lines = stringFile.split("\n");
        int numberOfMethods = 0;
        for (String line : lines) {
            if(isMethodLine(line))numberOfMethods++;
        }
        return numberOfMethods;
    }

    private static boolean isMethodLine(String line) {
        line = line.trim();
        if (line.startsWith("if(") || line.startsWith("for(") || line.startsWith("while(") || line.startsWith("switch(") || line.startsWith("catch(")) {
            return false;
        }
        else if (line.contains("){") || line.contains(")throws")) {
            return true;
        }
        return false;
    }

    private static ArrayList<String> getLineAttributes(File file) {
        String code = FileStringizer.format(FileStringizer.fileToString(file));
        String[] lines = code.split("\n");
        ArrayList<String> attributes = new ArrayList<>();
        int blockCounter = 0;
        for (String line : lines) {
            if (line.length() == 0) {
                continue;
            }
            if (line.contains("{")) {
                blockCounter++;
            } else if (line.contains("}")) {
                blockCounter--;
            } else if (blockCounter == 1) {
                attributes.add(line);
            }
        }
        return attributes;
    }
    
    public static int countAttributes(File file){
        return getLineAttributes(file).size();
    }

    public static ArrayList<String> identifyAttributes(File file) {
        ArrayList<String> attributes = new ArrayList<>();
        for (String line : getLineAttributes(file)) {
            if (line.contains("=")) {
                attributes.add(line.substring(0, line.indexOf("=")).trim().substring(line.substring(0, line.indexOf("=")).trim().lastIndexOf(" ") + 1, line.substring(0, line.indexOf("=")).trim().length()));
            } else {
                attributes.add(line.substring(line.lastIndexOf(" ") + 1, line.length() - 1));
            }
        }
        return attributes;
    }

    public static int attributeAccess(ArrayList<String> attributes, String code) {
        String[] lines = code.split("\n");
        int openedBlocks = 0;
        int apariciones = 0;
        String signature = "";

        for (String line : lines) {
            line = line.replace(" ", "");
            if (line.contains("{")) {
                openedBlocks++;
            }
            if (line.contains("}")) {
                openedBlocks--;
            }
            if (openedBlocks >= 2) {
                if (isMethodLine(line)) {
                    int inicio = line.indexOf("(");
                    int fin = line.indexOf(")");
                    signature = line.substring(inicio + 1, fin);
                } else {
                    for (String attribute : attributes) {
                        if (signature.contains(attribute)) {
                            if (line.contains("this." + attribute)) {
                                System.out.println("Linea: "+line);
                                apariciones++;
                            }
                        } else {
                            if (line.contains(attribute)) {
                                System.out.println("Linea: "+line);
                                apariciones++;
                            }
                        }
                    }
                }
            }
        }
        return apariciones;
    }
}
