
import java.io.File;
import java.util.ArrayList;
import lackofcohesioninmethods.LackOfCohesionMeter;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LackOfCohesioninMethodsTest {

    
    public void countMethodsInClassTest() {
        File file = new File("simpleClass.txt");
        assertEquals(4, LackOfCohesionMeter.countMethodsInClass(file));
    }

    @Test
    public void countAttributesInClassTest() {
        File file = new File("simpleClass.txt");
        assertEquals(5, LackOfCohesionMeter.countAttributes(file));
    }
    
    @Test
    public void identifytAttributesTest() {
        File file = new File("simpleClass.txt");
        ArrayList<String> attributes = new ArrayList<>();
        attributes.add("name");
        attributes.add("board");
        attributes.add("palabra");
        attributes.add("atributo");
        attributes.add("person");
        assertEquals(attributes, LackOfCohesionMeter.identifyAttributes((file)));
    }
    
    @Test
    public void attributeAccessTest(){
        File file = new File("simpleClass.txt");
        assertEquals(7, LackOfCohesionMeter.attributeAccess((file)));
        assertEquals(4, LackOfCohesionMeter.countMethodsInClass(file));
    }
}
