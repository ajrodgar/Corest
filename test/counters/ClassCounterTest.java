package counters;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class ClassCounterTest {
    Counter counter;
    @Before
    public void setUp(){
        counter = new ClassCounter();
    }

    @Test
    public void emptyDirectoryTest(){
        Assert.assertEquals(0, counter.count(new File("resource/empty.directory")));
    }

    @Test
    public void onlyClassesInOnlyOneDirectoryTest() {
        Assert.assertEquals(3, counter.count(new File("resource/only.classes.in.only.one.directory")));
    }

    @Test
    public void filesAndClassesInOnlyOneDirectoryTest() {
        Assert.assertEquals(3, counter.count(new File("resource/files.and.classes.in.only.one.directory")));
    }

    @Test
    public void filesAndClassesInADirectoryWithMoreDirectoriesTest() {
        Assert.assertEquals(3, counter.count(new File("resource/files.and.classes.in.directory.with.more.directories")));
    }

}
