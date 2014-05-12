package corest.projectanalyzer.javaprojectanalyzer.classdependency;

import corest.projectanalyzer.javaprojectanalyzer.Analysis;
import corest.projectanalyzer.javaprojectanalyzer.JavaProjectAnalyzer;
import static corest.projectanalyzer.javaprojectanalyzer.classdependency.NameFacilitator.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ClassDependencyEvaluator implements JavaProjectAnalyzer {

    List<String> dependencyList = new ArrayList<>();
    Map<String, String> projectClasses;
    String classNameToEvaluate;
    String classCode;
    
    public ClassDependencyEvaluator(Map<String, String> projectClasses) {
        this.projectClasses = projectClasses;
    }

    public ArrayList<String> getImportDependencies(String classCode) {
        ArrayList<String> importDependencies = new ArrayList<>();

        Scanner scanner = new Scanner(classCode);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains("import")) {
                if (line.contains("*")) {
                    for (String className : getClassesNamesFromPackage(getPackageNameFromImportLine(line), projectClasses)) {
                        dependencyList.add(className);
                        importDependencies.add(className);
                    }
                } else {
                    dependencyList.add(getClassNameFromImportLine(line));
                    importDependencies.add(getClassNameFromImportLine(line));
                }
            }
        }

        return importDependencies;
    }

    public ArrayList<String> getSamePackageDependencies(String classCode, String className) {
        ArrayList<String> samePackageDependencies = new ArrayList<>();

        String packageName = getPackageNameFromPackageLine(classCode);
        for (String projectClass : getClassesNamesFromPackage(packageName, projectClasses)) {
            if (classCode.contains(getClassFromHashMap(projectClass)) && !className.equals(projectClass)) {
                dependencyList.add(projectClass);
                samePackageDependencies.add(projectClass);
            }
        }

        return samePackageDependencies;

    }

    private String getClassFromHashMap(String projectClass) {
        String[] name = projectClass.split("\\.");
        return name[name.length - 1];
    }
    
    public List<String> getDependencyList() {
        return dependencyList;
    }

    @Override
    public Analysis getAnalysis() {
        getImportDependencies(classCode);
        getSamePackageDependencies(classCode, classNameToEvaluate);
        return new Analysis("ClassDependencyEvaluator", classNameToEvaluate, toStringDependencyList());
    }

    @Override
    public void setAnalizerParameter(String... analizerParameter) {
        classNameToEvaluate = analizerParameter[0];
        classCode = analizerParameter[1];
    }
    
    public String toStringDependencyList(){
        String dependencyListToString = "";
        for (String string : dependencyList) {
            dependencyListToString+=string + "; "; 
        }
        return dependencyListToString;
    }
}
