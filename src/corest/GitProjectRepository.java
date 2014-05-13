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
    public Map<String, String> getCodeClassProjectMap() {
        return fileMaps.getFileContentMap();
    }

    @Override
    public Map<String, String> getTreePackageMap() {
        return fileMaps.getTreeDirectoryMap();
    }

    @Override
    public String getSourcePath() {
        return fileMaps.getDirectoryProjectPath();
    }
}
