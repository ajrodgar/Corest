package main;

import analyzer.Analyzer;
import analyzer.results.AnalyzerResult;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Set;


public class GitRepository {
    String gitURL;
    String branch;
    FileListBuilder fileMaps;

    public GitRepository(String gitURL, String branch) {
        this.gitURL = gitURL;
        this.branch = branch;
    }
    
    public GitRepository(String gitURL) {
        this(gitURL, "master");
    }
    
        
    public void generateDirectory(String ruta){
       fileMaps = new FileListBuilder(ruta);
    }
    
    public AnalyzerResult analyze(String key, String analyzerToUse, String fileTxt) throws Exception{
        Analyzer analyzer;
        Class<?> c;
        c = Class.forName("analyzer."+analyzerToUse);
        Constructor<?> cons = c.getConstructor(String.class, String.class);
        Analyzer a = (Analyzer) cons.newInstance(key, fileTxt);
       
        return a.getResult();    
    }
    
    public ArrayList<AnalyzerResult> analyzeAll(String analyzerToUse) throws Exception{
        ArrayList<AnalyzerResult> result = new ArrayList<>();
        Set<String> keys =fileMaps.getFileContentMap().keySet();
        
        for (String string : keys) {
            //System.out.println("\nKey: "+string);
            result.add(analyze(string, analyzerToUse, fileMaps.getFileContentMap().get(string)));
        }
        
        return result;
    }

    public FileListBuilder getFileMaps() {
        return fileMaps;
    }
}
