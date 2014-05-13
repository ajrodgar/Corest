package corest;

import corest.projectanalyzer.javaprojectanalyzer.Analysis;
import corest.projectanalyzer.javaprojectanalyzer.JavaProjectAnalyzer;
import corest.projectanalyzer.javaprojectanalyzer.classcounter.ClassCounter;
import corest.projectanalyzer.javaprojectanalyzer.classdependency.ClassDependencyEvaluator;
import corest.projectanalyzer.javaprojectanalyzer.codelinecounter.AnalyzerCodeLineCounter;
import corest.projectanalyzer.javaprojectanalyzer.cyclomaticcomplexity.AnalyzerCyclomaticComplexity;
import corest.projectanalyzer.javaprojectanalyzer.lackofcohesionmethod.AnalyzerLackOfCohesionMethod;
import corest.projectanalyzer.javaprojectanalyzer.rank.RankCalculator;
import java.util.ArrayList;
import java.util.List;

public class Corest {

    ProjectRepository projectRepository;

    public Corest(String url) {
        this(url, "master");
    }

    public Corest(String url, String branch) {
        this.projectRepository = new GitProjectRepository(url, branch);
    }

    public Analysis getClassCounter() {
        return initializeClassCounter().getAnalysis();
    }

    private ClassCounter initializeClassCounter() {
        ClassCounter classCounter = new ClassCounter();
        classCounter.setAnalizerParameter(projectRepository.getSourcePath());
        return classCounter;
    }

    public List<Analysis> getAnalizerClassDependency() {
        return getAnalysis(new ClassDependencyEvaluator(
                projectRepository.getTreePackageMap()));
    }

    public List<Analysis> getAnalyzerCodeLineCounter() {
        return getAnalysis(new AnalyzerCodeLineCounter());
    }

    public List<Analysis> getAnalyzerCyclomaticComplexity() {
        return getAnalysis(new AnalyzerCyclomaticComplexity());
    }

    public List<Analysis> getAnalyzerLackOfCohesionMethod() {
        return getAnalysis(new AnalyzerLackOfCohesionMethod());
    }

    public List<Analysis> getAnalyzerRank(){
        return getAnalysis(new RankCalculator(projectRepository.getCodeClassProjectMap(),
                projectRepository.getTreePackageMap()));
    }

    private List<Analysis> getAnalysis(JavaProjectAnalyzer javaProjectAnalyzer) {
        List<Analysis> analysisList = new ArrayList<>();
        for (String className : projectRepository.getCodeClassProjectMap().keySet()) {
            analysisList.add(analyze(javaProjectAnalyzer, className));
        }
        return analysisList;
    }

    private Analysis analyze(JavaProjectAnalyzer javaProjectAnalyzer, String className) {
        javaProjectAnalyzer.setAnalizerParameter(className,
                projectRepository.getCodeClassProjectMap().get(className));
        return javaProjectAnalyzer.getAnalysis();
    }
}
