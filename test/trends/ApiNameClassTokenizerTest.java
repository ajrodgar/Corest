package trends;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

public class ApiNameClassTokenizerTest {
    
    @Test
    public void tokenizerSimpleNameClass(){
        ApiNameClassTokenizer tokenizer = new ApiNameClassTokenizer();
        ArrayList<String> token = tokenizer.tokens("ApiNameClassTokenizer");
        assertEquals("Api",token.get(0));
        assertEquals("Name",token.get(1));
        assertEquals("Class",token.get(2));
        assertEquals("Tokenizer",token.get(3));
    }

}
