package corest.rank;

import corest.classdependenciesevaluator.ClassDependenciesEvaluator;
import java.util.ArrayList;
import java.util.HashMap;

public class RankCalculator {

    private final ClassDependenciesEvaluator evaluator;
    private final HashMap<String, String> project;

    public RankCalculator(HashMap<String, String> project, ClassDependenciesEvaluator evaluator) {
        this.project = project;
        this.evaluator = evaluator;
    }

    public double calculate(String className) {
        double result = 0;
        for (String dependentClass : evaluator.getDependencies(project.get(className), className)) {
            if (dependentClass.equals(className)) continue;
            result += calculate(dependentClass) / numberOfDependentClasses(dependentClass);
        }
        return result * 0.85 + 0.15;
    }

    private double numberOfDependentClasses(String className) {
        return dependentClasses(className).isEmpty() ? 1 : dependentClasses(className).size();
    }

    private ArrayList<String> dependentClasses(String className) {
        return evaluator.getDependencies(project.get(className), className);
    }
}
