package counters;


import counters.CodeLineCounter;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class LineCounterTest {
    
    @Test
    public void lineCounterTest() throws IOException {
        Assert.assertEquals(7, new CodeLineCounter("resource/only.classes.in.only.one.directory/1Class.java").countLines());
    }
    
    @Test
    public void commentCounterTest() throws IOException {
        Assert.assertEquals(2, new CodeLineCounter("resource/only.classes.in.only.one.directory/1Class.java").countComments());
    }
    
    
}
