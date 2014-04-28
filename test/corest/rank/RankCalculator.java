package corest.rank;

public class RankCalculator {

    public double calculate(String className, DependencyDictionary dictionary) {
       double result = 0;
       for (String dependentClass : dictionary.getDependentClasses().get(className)) {
            result += calculate(dependentClass, dictionary) / numberOfDependentClasses();
        }
        return result * 0.85 + 0.15;
    }

    private double numberOfDependentClasses() {
        return 1;
    }
}
