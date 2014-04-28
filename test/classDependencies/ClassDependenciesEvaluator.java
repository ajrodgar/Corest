package classDependencies;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static classDependencies.NameFacilitator.*;

public class ClassDependenciesEvaluator {
    ArrayList<String> dependencies = new ArrayList<>();
    HashMap<String,String> projectClasses;

    ClassDependenciesEvaluator(HashMap<String, String> projectClasses) {
        this.projectClasses = projectClasses;
    }
    
    public ArrayList<String> getDependencies(String classCode, String className) {
        getImportDependencies(classCode);
        getSamePackageDependencies(classCode, className);
        return dependencies;
    }


    private void getImportDependencies(String classCode) {
        Scanner scanner = new Scanner(classCode);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.contains("import")){
                if(line.contains("*"))
                    for (String className : getClassesNamesFromPackage(getPackageNameFromImportLine(line), projectClasses))
                        dependencies.add(className);
                else
                    dependencies.add(getClassNameFromImportLine(line));
            }
        }
    }
    
    private void getSamePackageDependencies(String classCode, String className) {
        String packageName = getPackageNameFromPackageLine(classCode);
        for (String projectClass : getClassesNamesFromPackage(packageName, projectClasses))
            if (classCode.contains(getClassFromHashMap(projectClass)) && !className.equals(projectClass))
                dependencies.add(projectClass);

    }
    
    private String getClassFromHashMap(String projectClass){
        String[] name = projectClass.split("\\.");
        return name[name.length-1];
    }
    
}
