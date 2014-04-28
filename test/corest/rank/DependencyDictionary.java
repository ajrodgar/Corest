package corest.rank;

import java.util.ArrayList;

public interface DependencyDictionary {
    
    public ArrayList<String> getDependentClasses(String file, String className);
}
