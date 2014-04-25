package counters;

import java.io.File;
import java.io.FilenameFilter;
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

    private int countClassInDirectory(File directory){
        return directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File directory, String nameFile) {
                return nameFile.contains(".java");
            }
        }).length;
    }

}
