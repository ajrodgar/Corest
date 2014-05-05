package main;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.errors.GitAPIException;

public class GitRepositoryLoader {
    
    public static GitRepository loadRepository(String GitURL, String branch){
        GitRepository gitRepo= new GitRepository(GitURL, branch);
        
        loadTemp(GitURL, branch, gitRepo);

        return gitRepo;
    }
    
    private static void loadTemp(String gitURL, String branch, GitRepository gitRepo){
        //c.setU//RI("https://bitbucket.org/Adrian_M/hpds-expressionevaluator.git"); errores en bitbucket - autentificación 
        CloneCommand c = new CloneCommand();
        c.setURI(gitURL);
        c.setBranch(branch);

        
        Date date = new Date();
        String folderT= gitURL+new Timestamp(date.getTime());
        String folder= folderT.replaceAll("[:\\.\\-\\ \\/]", "");
        
        String rutaSrc = "temp/"+folder;

        c.setDirectory(new File(rutaSrc));
       
        try {
            c.call();
        } catch (GitAPIException ex) {
            Logger.getLogger(GitRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        gitRepo.generateDirectory(rutaSrc);
    }
    
}
