package corest.rank;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class DependencyDictionary {

    private final HashMap<String, ArrayList<String>> dictionary;
    
    public DependencyDictionary(ArrayList<File> files) {
        dictionary = new HashMap<>();
        files.stream().forEach((file) -> dictionary.put(className(file), new ArrayList<>()));
    }

    private static String className(File file) {
        return file.getName().substring(0, file.getName().lastIndexOf(".java"));
    }
    
    public boolean isProjectClass(String className) {
        return dictionary.containsKey(className);
    } 
}
