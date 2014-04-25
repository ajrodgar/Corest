package classDependencies;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClassDependenciesEvaluator {
    ArrayList<String> dependencies = new ArrayList<>();
    HashMap<String,String> projectClasses;
    private final String fileName;

    ClassDependenciesEvaluator(HashMap<String, String> projectClasses, String fileName) {
        this.projectClasses = projectClasses;
        this.fileName = fileName;
    }
    
    public ArrayList<String> getDependencies(String file) {
        getImportDependencies(file);
        getSamePackageDependencies(file);
        return dependencies;
    }

    private String getClassName(String line) {
        return line.split(" ")[1].split(";")[0];
    }

    private void getImportDependencies(String file) {
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.contains("import"))
                dependencies.add(getClassName(line));
        }
    }

    private void getSamePackageDependencies(String file) {
        String packageName = getPackageName(file);
        for (String projectClass : getClassesFromPackage(packageName)) {
            
            if (file.contains(getClassFromHashMap(projectClass)) && !getFileClassName(file).equals(projectClass))
                dependencies.add(projectClass);
        }
    }
    
    public ArrayList<String> getClassesFromPackage(String classPackage) {
        ArrayList<String> list = new ArrayList<>();
        for (String projectClass : projectClasses.keySet()) {
            if (projectClasses.get(projectClass).equals(classPackage)) {
                list.add(projectClass);
            }
        }
        return list;
    }

    private String getPackageName(String file) {
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.contains("package"))
                return line.split(" ")[1].split(";")[0];
        }
        return null;
    }
    
    private String getFileClassName(String file){
        return getPackageName(file)+"."+fileName.split("\\.")[0];
    }
    
    private String getClassFromHashMap(String projectClass){
        String[] name = projectClass.split("\\.");
        return name[name.length-1];
    }
    
}
