import java.io.File;
import lackofcohesioninmethods.LackOfCohesionMeter;
import org.junit.Test;
import static org.junit.Assert.*;


public class LackOfCohesioninMethodsTest {
    
    
    @Test
    public void countMethodsinClassTest(){        
        File file=new File("simpleClass.txt");
        assertEquals(4, LackOfCohesionMeter.countMethodsInClass(file)); 
    }
}
