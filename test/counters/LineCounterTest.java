package counters;

import java.io.File;
import java.io.IOException;

import counters.LineCounter;
import org.junit.Assert;
import org.junit.Test;

public class LineCounterTest {
    
    @Test
    public void myFirstTest() throws IOException{
        Assert.assertEquals(5, new LineCounter("resource/only.classes.in.only.one.directory/1Class.class").count());
    }
}
