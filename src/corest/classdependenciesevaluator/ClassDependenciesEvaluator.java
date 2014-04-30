package corest.classdependenciesevaluator;

import static corest.classdependenciesevaluator.NameFacilitator.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ClassDependenciesEvaluator {
    ArrayList<String> dependencies = new ArrayList<>();
    HashMap<String,String> projectClasses;

    public ClassDependenciesEvaluator(HashMap<String, String> projectClasses) {
        this.projectClasses = projectClasses;
    }
    
    public ArrayList<String> getDependencies(String classCode, String className) {
        getImportDependencies(classCode);
        getSamePackageDependencies(classCode, className);
        return dependencies;
    }


    private void getImportDependencies(String classCode) {
        String data[] = classCode.split("\n");
        for (String line : data) {
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
