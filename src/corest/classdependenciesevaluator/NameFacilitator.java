package corest.classdependenciesevaluator;

import java.util.ArrayList;
import java.util.HashMap;

public class NameFacilitator {

    protected static ArrayList<String> getClassesNamesFromPackage(String classPackage, HashMap<String,String> projectClasses) {
        ArrayList<String> list = new ArrayList<>();
        for (String projectClass : projectClasses.keySet()) {
            if (projectClasses.get(projectClass).equals(classPackage)) {
                list.add(projectClass);
            }
        }
        return list;
    }

    protected static String getClassNameFromImportLine(String line) {
        return line.split(" ")[1].split(";")[0];
    }
    
    protected static String getPackageNameFromPackageLine(String classCode) {
        String data[] = classCode.split("\n");
        for (String line : data) {
            if (line.contains("package")) {
                return line.split(" ")[1].split(";")[0];
            }
        }
        return "";
    }

    protected static String getPackageNameFromImportLine(String line) {
        String packageName = line.split(" ")[1];
        return packageName.substring(0, packageName.length() - 3);
    }

    
}
