
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class LineCounterTest {
    
    @Test
    public void lineCounterTest() throws IOException {
        Assert.assertEquals(7, new CodeLineCounter("src/myFile.txt").countLines());
    }
    
    @Test
    public void commentCounterTest() throws IOException {
        Assert.assertEquals(2, new CodeLineCounter("src/myFile.txt").countComments());
    }
    
    
}
