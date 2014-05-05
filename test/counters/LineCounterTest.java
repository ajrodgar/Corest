package counters;


import java.io.File;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class LineCounterTest {
    
    File test1 = new File("resource/only.classes.in.only.one.directory/1Class.java");
    
    @Test
    public void lineCounterTest() throws IOException {
        Assert.assertEquals(9, new CodeLineCounter(test1).countLines());
    }
    
    @Test
    public void commentCounterTest() throws IOException {
        Assert.assertEquals(4, new CodeLineCounter(test1).countComments());
    }

}
