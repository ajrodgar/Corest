package corest;

import java.util.Map;

public interface ProjectRepository {


    public Map<String, String> getFileContentMap();

    public Map<String, String> getTreeDirectoryMap();

    public String getSourcePath();
}
