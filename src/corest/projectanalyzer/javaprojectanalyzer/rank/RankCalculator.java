package corest.projectanalyzer.javaprojectanalyzer.rank;

import corest.projectanalyzer.javaprojectanalyzer.Analysis;
import corest.projectanalyzer.javaprojectanalyzer.JavaProjectAnalyzer;
import corest.projectanalyzer.javaprojectanalyzer.classdependency.ClassDependencyEvaluator;
import java.util.List;
import java.util.Map;

public class RankCalculator implements JavaProjectAnalyzer{

    private final ClassDependencyEvaluator evaluator;
    private final Map<String, String> project;
    private String classNameToEvaluate;

    public RankCalculator(Map<String, String> project, Map<String, String> projectClasses) {
        this.project = project;
        this.evaluator = new ClassDependencyEvaluator(projectClasses);
    }

    public double calculate(String className) {
        double result = 0;
        initializeEvaluator(className);
        for (String dependentClass : evaluator.getDependencyList()) {
            if (dependentClass.equals(className)) {
                continue;
            }
            result += calculate(dependentClass) / numberOfDependentClasses(dependentClass);
        }
        return result * 0.85 + 0.15;
    }

    private void initializeEvaluator(String className) {
        evaluator.setAnalizerParameter(className, project.get(className));
    }

    private double numberOfDependentClasses(String className) {
        return dependentClasses(className).isEmpty() ? 1 : dependentClasses(className).size();
    }

    private List<String> dependentClasses(String className) {
        initializeEvaluator(className);
        return evaluator.getDependencyList();
    }

    @Override
    public Analysis getAnalysis() {
        return new Analysis("Rank", classNameToEvaluate,
                Double.toString(calculate(classNameToEvaluate)));
    }

    @Override
    public void setAnalizerParameter(String... analizerParameter) {
        classNameToEvaluate = analizerParameter[0];
    }
}
