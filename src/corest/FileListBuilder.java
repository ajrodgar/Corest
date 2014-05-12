package corest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileListBuilder {
    private final String directory;
    private final Map<String, String> fileContentMap;
    private final Map<String, String> treeDirectoryMap;

    public FileListBuilder(String directory) {
        this.directory = directory;
        this.fileContentMap = new HashMap<>();
        this.treeDirectoryMap = new HashMap<>();
        CreateMaps(directory);
    }

    public String getDirectory() {
        return directory;
    }
    
    public final void CreateMaps(String directory){
        fileMapBuilder(getSourceDirectory(directory),"");
    }
    
    public void fileMapBuilder(String sourcePath, String directoryName) {
        if (sourcePath != null) {
            File proyectDirectory = new File(sourcePath);
            File[] children = proyectDirectory.listFiles();
            for (File file : children) {
                if (file.isDirectory()) {
                    fileMapBuilder(file.getAbsolutePath(), (buildPackageName(directoryName, file.getName())));
                }
                else if(isJavaFile(file.getName())) { 
                    treeDirectoryMap.put(directoryName+"."+file.getName(), directoryName);
                    fileContentMap.put(directoryName+"."+file.getName(), loadFileContent(file));
                }
            }
        }
    }

    public String getSourceDirectory(String directory) {
        File proyectDirectory = new File(directory);
        File[] children = proyectDirectory.listFiles();
        for (File file : children) {
            if (file.isDirectory() && (file.getName().equals("src") || file.getName().equals("source"))) {
                return file.getAbsolutePath();
            }
        }
        return null;
    }

    private String buildPackageName(String directoryName, String name) {
        if (directoryName.equals("")) {
            return name;
        } else {
            return directoryName + "." + name;
        }
    }

    private boolean isJavaFile(String name) {
        return name.toLowerCase().contains(".java");
    }

    private String loadFileContent(File file) {
        String fileContent = "";
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                fileContent+=line+"\n";
            }
            fileReader.close();
        }
        catch(IOException e) {
            System.out.println("Fail reading the file "+ file + ": " + e);
        }
        return fileContent;
    }

    public Map<String, String> getFileContentMap() {
        return fileContentMap;
    }

    public Map<String, String> getTreeDirectoryMap() {
        return treeDirectoryMap;
    }
}
