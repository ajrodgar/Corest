package corest.rank;

import java.util.ArrayList;
import java.util.HashMap;

public interface DependencyDictionary {
    
    public HashMap<String, ArrayList<String>> getDependentClasses();
}
