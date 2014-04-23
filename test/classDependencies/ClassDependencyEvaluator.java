package classDependencies;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ClassDependencyEvaluator {

    public ArrayList<String> getDependencies(String file) {
        ArrayList<String> dependencies = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.contains("import"))
                dependencies.add(line.split(" ")[1].split(";")[0]);
        }
        return dependencies;
    }
    
}
