package counters;

import junit.framework.Assert;
import org.junit.Test;

import java.io.File;

public class ClassCounterTest {

    @Test
    public void onlyClassesInOnlyOneDirectoryTest() {
        Counter counter = new ClassCounter();
        Assert.assertEquals(3, counter.count(new File("resource/only.classes.in.only.one.directory")));
    }

    @Test
    public void filesAndClassesInOnlyOneDirectoryTest() {
        Counter counter = new ClassCounter();
        Assert.assertEquals(3, counter.count(new File("resource/files.and.classes.in.only.one.directory")));
    }

    @Test
    public void filesAndClassesInADirectoryWithMoreDirectoriesTest() {
        Counter counter = new ClassCounter();
        Assert.assertEquals(3, counter.count(new File("resource/files.and.classes.in.directory.with.more.directories")));
    }

}
