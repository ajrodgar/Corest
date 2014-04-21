
import java.io.IOException;
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

public class LineCounterTest {
    
    @Test
    public void myFirstTest() throws IOException{
        Assert.assertEquals(5, new LineCounter("src/myFile.txt").count());
    }
}
