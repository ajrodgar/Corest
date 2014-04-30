package main;

import analyzer.Analyzer;
import analyzer.MyResult;
import java.io.File;
import java.lang.reflect.Constructor;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.errors.GitAPIException;


public class MainController {
    String gitURL;
    String branch;
    FileListBuilder fileMaps;

    public MainController(String gitURL) {
        this.gitURL = gitURL;
        this.branch = "master";
        this.getFiles();
    }
    
    private void getFiles(){
        //c.setU//RI("https://bitbucket.org/Adrian_M/hpds-expressionevaluator.git"); errores en bitbucket - autentificación 
        CloneCommand c = new CloneCommand();
        c.setURI(gitURL);
        //c.setBranch(branch);
        c.setBranch("develop");
        
        Date date = new Date();
        String folderT= gitURL+new Timestamp(date.getTime());
        String folder= folderT.replaceAll("[:\\.\\-\\ \\/]", "");
        
        String rutaSrc = "C://Users//usuario//Desktop//"+folder;
        //c.setDirectory(new File("C://temp//"+folder));
        c.setDirectory(new File(rutaSrc));
       
        try {
            c.call();
        } catch (GitAPIException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        generateDirectory(rutaSrc);
    }
    
    private void generateDirectory(String ruta){
       fileMaps = new FileListBuilder(ruta);
    }
    
    public MyResult analyze(String analyzerToUse, String fileTxt) throws Exception{
        Analyzer analyzer;
        Class<?> c;
        c = Class.forName("analyzer."+analyzerToUse);
        Constructor<?> cons = c.getConstructor(String.class);
        Analyzer a = (Analyzer) cons.newInstance(fileTxt);
       
        return a.getResult();    
    }
    
    public ArrayList<MyResult> analyzeAll(String analyzerToUse) throws Exception{
        ArrayList<MyResult> result = new ArrayList<>();
        Set<String> keys =fileMaps.getFileContentMap().keySet();
        
        for (String string : keys) {
            System.out.println("\nKey: "+string);
            result.add(analyze(analyzerToUse, fileMaps.getFileContentMap().get(string)));
        }
        
        return result;
    }
}
