package corest.rank;

import java.util.ArrayList;
import java.util.HashMap;

public class RankCalculator {
    
    private final DependencyDictionary dictionary;
    private final HashMap<String, String> project;

    public RankCalculator(HashMap<String, String> project, DependencyDictionary dictionary) {
        this.project = project;
        this.dictionary = dictionary;
    }

    public double calculate(String className) {
       double result = 0;
       for (String dependentClass : dictionary.getDependentClasses(project.get(className), className))
            result += calculate(dependentClass) / numberOfDependentClasses(dependentClass);
        return result * 0.85 + 0.15;
    }

    private double numberOfDependentClasses(String className) {
        return dependentClasses(className).isEmpty() ? 1 : dependentClasses(className).size();
    }
    
    private ArrayList<String> dependentClasses(String className) {
        return dictionary.getDependentClasses(project.get(className), className);
    }
}
