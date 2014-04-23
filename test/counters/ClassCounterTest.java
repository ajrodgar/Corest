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

}
