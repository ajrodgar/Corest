package corest;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jgit.api.CloneCommand;
import org.eclipse.jgit.api.errors.GitAPIException;


public class GitProjectRepository implements ProjectRepository {
    String gitURL;
    String branch;
    FileListBuilder fileMaps;

    public GitProjectRepository(String gitURL, String branch) {
        super();
        this.gitURL = gitURL;
        this.branch = branch;
        loadRepository();
    }
    
    public GitProjectRepository(String gitURL) {
        this(gitURL, "master");
    }
    
     private void loadRepository(){
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
            generateRepositoryFileMap(rutaSrc);
        } catch (GitAPIException ex) {
            Logger.getLogger(GitProjectRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
    private void generateRepositoryFileMap(String repositoryPath){
       fileMaps = new FileListBuilder(repositoryPath);
    }
    
    public FileListBuilder getFileMaps() {
        return fileMaps;
    }

    @Override
    public Map<String, String> getFileContentMap() {
        return fileMaps.getFileContentMap();
    }

    @Override
    public Map<String, String> getTreeDirectoryMap() {
        return fileMaps.getTreeDirectoryMap();
    }

    @Override
    public String getSourcePath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
