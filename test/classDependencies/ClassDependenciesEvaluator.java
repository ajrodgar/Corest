package classDependencies;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassDependenciesEvaluator {
    ArrayList<String> dependencies = new ArrayList<>();
    
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
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
}
