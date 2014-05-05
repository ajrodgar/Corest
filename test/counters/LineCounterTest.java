package counters;


import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

public class LineCounterTest {
    
    String test1 = "Esto es un fichero\n"
            + "de dos líneas\n"
            + "//Esto es un comentario de linea\n"
            + "/*Esto seria un comentario de bloque\n"
            + "y por eso tiene varias lineas\n"
            + "tres concreto*/\n";
    
    @Test
    public void lineCounterTest() throws IOException {
        Assert.assertEquals(6, new CodeLinesCounter(test1).countLines());
    }
    
    @Test
    public void commentCounterTest() throws IOException {
        Assert.assertEquals(2, new CodeLinesCounter(test1).countComments());
    }

}
