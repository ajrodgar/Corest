import java.io.File;
import lackofcohesioninmethods.LackOfCohesionMeter;
import org.junit.Test;
import static org.junit.Assert.*;


public class LackOfCohesioninMethodsTest {
    
    
    @Test
    public void countMethodsInClassTest(){        
        File file=new File("simpleClass.txt");
        assertEquals(4, LackOfCohesionMeter.countMethodsInClass(file)); 
    }
    
    //@Test
    public void countAttributesInClassTest(){
        File file=new File("simpleClass.txt");
        //assertEquals(2, LackOfCohesionMeter.countAttributesInClass(file));
    }    
    
}
