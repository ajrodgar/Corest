package counters;

import java.io.File;
import java.io.IOException;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ClassCounter implements Counter{

    @Override
    public int count(File file) {
        int classNumber = countClassInDirectory(file);
        for (File directory : getDirectoriesList(file))
            classNumber+= count(directory);
        return classNumber;
    }

    private List<File> getDirectoriesList(File externalDirectory) {
        List<File> list = new LinkedList<File>();
        for (File file: externalDirectory.listFiles())
            if (file.isDirectory())
                list.add(file);
        return list;
    }

    private List<File> getFilesList(File directory) {
        return Arrays.asList(directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File directory, String nameFile) {
                return nameFile.contains(".java");
            }
        }));
    }

    private int countClassInDirectory(File directory){
        int classNumber=0;
        for (File file : getFilesList(directory)) {
            classNumber+=1+countInnerClasses(file);
        }
        return classNumber;
    }

    private int countInnerClasses(File fileClass) {
        try {
            String string = new String(Files.readAllBytes(Paths.get(fileClass.getPath())));
            if(string.contains("class"))
                return string.length() - string.replaceAll("class" , "clss").length() - 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
