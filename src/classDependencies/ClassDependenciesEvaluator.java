package classDependencies;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import static classDependencies.NameFacilitator.*;

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


    public ArrayList<String> getImportDependencies(String classCode) {
        ArrayList<String> importDependencies = new ArrayList<>();
        
        Scanner scanner = new Scanner(classCode);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.contains("import")){
                if(line.contains("*"))
                    for (String className : getClassesNamesFromPackage(getPackageNameFromImportLine(line), projectClasses)){
                        dependencies.add(className);
                        importDependencies.add(className);
                    }
                else{
                    dependencies.add(getClassNameFromImportLine(line));
                    importDependencies.add(getClassNameFromImportLine(line));
                }
            }
        }
        
        return importDependencies;
    }
    
    public ArrayList<String> getSamePackageDependencies(String classCode, String className) {
        ArrayList<String> samePackageDependencies = new ArrayList<>();
        
        String packageName = getPackageNameFromPackageLine(classCode);
        for (String projectClass : getClassesNamesFromPackage(packageName, projectClasses))
            if (classCode.contains(getClassFromHashMap(projectClass)) && !className.equals(projectClass)){
                dependencies.add(projectClass);
                samePackageDependencies.add(projectClass);
            }
        
        return samePackageDependencies;

    }
    
    private String getClassFromHashMap(String projectClass){
        String[] name = projectClass.split("\\.");
        return name[name.length-1];
    }
    
}
