package main;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jgit.api.*;
import org.eclipse.jgit.api.errors.GitAPIException;

public class MainController {
    ArrayList<File> fileList;
    String gitURL;
    String branch;

    public MainController(String gitURL) {
        this.gitURL = gitURL;
        this.branch = "master";
        this.getFiles();
    }
    
    private ArrayList<File> getFiles(){
        //c.setU//RI("https://bitbucket.org/Adrian_M/hpds-expressionevaluator.git"); errores en bitbucket - autentificación 
        CloneCommand c = new CloneCommand();
        c.setURI(gitURL);
        //c.setBranch(branch);
        c.setBranch("develop");
        
        Date date = new Date();
        String folderT= gitURL+new Timestamp(date.getTime());
        String folder= folderT.replaceAll("[:\\.\\-\\ \\/]", "");
        
        //c.setDirectory(new File("C://temp//"+folder));
        c.setDirectory(new File("C://Users//usuario//Desktop//"+folder));
       
        try {
            c.call();
        } catch (GitAPIException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    
}
