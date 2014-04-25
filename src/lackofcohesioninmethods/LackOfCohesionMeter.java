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
            numberOfMethods += processLine(line);
        }
        return numberOfMethods;
    }

    private static int processLine(String line) {
        if (line.contains("if") || line.contains("for") || line.contains("while") || line.contains("switch") || line.contains("catch")) {
            return 0;
        }
        if (line.contains("){") || line.contains(")throws")) {
            return 1;
        }
        return 0;
    }

    public static ArrayList<String> getLineAttributes(File file) {
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

    public static ArrayList<String> identifyAttributes(ArrayList<String> attributeLines) {
        ArrayList<String> attributes = new ArrayList<>();
        for (String line : attributeLines) {
            if (line.contains("=")) {
                attributes.add(line.substring(0,line.indexOf("=")).trim().substring(line.substring(0,line.indexOf("=")).trim().lastIndexOf(" ") + 1, line.substring(0,line.indexOf("=")).trim().length()));
            } else {
                attributes.add(line.substring(line.lastIndexOf(" ")+1, line.length() - 1));
            }
        }
        return attributes;
    }
}
