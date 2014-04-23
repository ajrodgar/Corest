package classDependencies;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassDependenciesEvaluator {

    public ArrayList<String> getDependencies(String file) {
        ArrayList<String> dependencies = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.contains("import"))
                dependencies.add(getClassName(line));
        }
        return dependencies;
    }

    private String getClassName(String line) {
        return line.split(" ")[1].split(";")[0];
    }
    
}
