package corest;

import java.util.Map;

public interface ProjectRepository {


    public Map<String, String> getCodeClassProjectMap();

    public Map<String, String> getTreePackageMap();

    public String getSourcePath();
}
