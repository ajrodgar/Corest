package CyclomaticComplexity;


import java.io.File;
import org.junit.Test;
import org.junit.Assert;

public class CyclomaticComplexityTest {

    @Test
    public void openFile() {
        File file;
        
        file = new File("C:\\archivo.txt");
        Assert.assertEquals(false, file.exists());
        
        file = new File("resources/nuevo.txt");
        Assert.assertEquals(true, file.exists());
    }
    
    @Test
    public void readFile(){
        File file = new File("resources/nuevo.txt");
        Assert.assertEquals(true, file.canRead());       
    }

    @Test
    public void cyclomaticComplexityTestSimple() {         
        CyclomaticComplexity cyclo = new CyclomaticComplexity();        
        Assert.assertEquals(6, cyclo.getComplexity(cyclo.getFile("Ejemplo1")));        
        Assert.assertEquals(17, cyclo.getComplexity(cyclo.getFile("Ejemplo2")));    
    }
    
    @Test
    public void cyclomaticComplexityTextWithComentCode(){
        CyclomaticComplexity cyclo = new CyclomaticComplexity();
        Assert.assertEquals(4, cyclo.getComplexity(cyclo.getFile("Ejemplo3")));
    }
}
