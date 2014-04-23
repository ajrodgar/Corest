package counters;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class ClassCounter implements Counter{

    @Override
    public int count(File file) {
        return file.listFiles().length;
    }


}
