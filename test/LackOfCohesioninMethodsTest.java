
import java.io.File;
import java.util.ArrayList;
import lackofcohesioninmethods.FileStringizer;
import lackofcohesioninmethods.LackOfCohesionMeter;
import lackofcohesioninmethods.Method;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LackOfCohesioninMethodsTest {
    
    private String initializeStringFile(){
        File file = new File("simpleClass.txt");
        return FileStringizer.fileToString(file);
    }
    
    @Test
    public void countMethodsInClassTest() {
        assertEquals(5, LackOfCohesionMeter.countMethods(initializeStringFile()));
    }

    @Test
    public void countAttributesInClassTest() {
        assertEquals(7, LackOfCohesionMeter.countAttributes(initializeStringFile()));
    }
    
    @Test
    public void identifytAttributesTest() {
        ArrayList<String> attributes = new ArrayList<>();
        attributes.add("name");
        attributes.add("board");
        attributes.add("palabra");
        attributes.add("palabra2");
        attributes.add("atributo");
        attributes.add("array");
        attributes.add("person");
        assertEquals(attributes, LackOfCohesionMeter.identifyAttributeNames((initializeStringFile())));
    }
    
    @Test
    public void isAccessingAnAttributeWhitThisTest(){
        Method method = new Method();
        method.setSignature("public void metodoPrueba(String name){");
        method.setBody("this.name = \"nombre\";\nboard = null;");
        
        Assert.assertTrue(method.isAccessing("name"));
    }
    
    @Test
    public void isAccessingAnAttributeTest(){
        Method method = new Method();
        method.setSignature("public void metodoPrueba(String name){");
        method.setBody("this.name = \"nombre\";\nboard = null;");
        
        Assert.assertTrue(method.isAccessing("board"));
    }
    
    @Test
    public void isNotAccessingAnAttributeTest(){
        Method method = new Method();
        method.setSignature("public void metodoPrueba(String name){");
        method.setBody("name = \"nombre\";\nboard = null;");
        
        Assert.assertFalse(method.isAccessing("name"));
    }
    
    @Test
    public void countMethodLines(){
        Method method = new Method();
        method.setSignature("public void metodoPrueba(String name){");
        method.setBody("name = \"nombre\";\nboard = null;");
        
        assertEquals(2, method.getNumberOfLines());
    }
}