package corest.projectanalyzer.javaprojectanalyzer;

public class Analysis {

    String analyzerName;
    String analyzedObjectName;
    String analysisResult;

    public Analysis(String analyzerName, String analyzedObjectName, String analysisResult) {
        this.analyzerName = analyzerName;
        this.analysisResult = analysisResult;
        this.analyzedObjectName = analyzedObjectName;
    }

    public String getAnalyzerName() {
        return analyzerName;
    }

    public String getAnalyzedObjectName() {
        return analyzedObjectName;
    }

    public String getAnalysisResult() {
        return analysisResult;
    }
}
