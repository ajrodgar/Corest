package classDependencies;

import java.util.ArrayList;

public class ClassDependencyEvaluator {

    public ArrayList<String> getDependencies(String file) {
        return new ArrayList<String>() {
            {
                add("evaluator.Expression");
            }
        };
    }
    
}
