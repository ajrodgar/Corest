package corest;

import corest.projectanalyzer.javaprojectanalyzer.Analysis;
import corest.projectanalyzer.javaprojectanalyzer.JavaProjectAnalyzer;


public class AnalyzerFake implements JavaProjectAnalyzer{
    String file;
    String source;
    String resultTXT;
    
    public AnalyzerFake(String key, String src) {
        this.file= key;
        this.source = src;
        calculateResultTXT();
    }
    
    private void calculateResultTXT(){
        
        resultTXT=source;
    }
    
    @Override
    public Analysis getAnalysis() {
        
        return new Analysis("AnalyzerFake",file,resultTXT);
    }

    @Override
    public void setAnalizerParameter(String... analizerParameter) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
