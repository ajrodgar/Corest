package trends;

import trend.relevantNames.ApiClassNameTokenizer;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class ApiClassNameTokenizerTest {

    private ArrayList<String> listClass;

    public void setUpListClassWithOneNameClass() {
        listClass = new ArrayList();
        listClass.add("ApiNameClassTokenizer");
    }

    @Test
    public void tokenizerOneNameClass() {
        ApiClassNameTokenizer tokenizer = new ApiClassNameTokenizer();
        setUpListClassWithOneNameClass();
        List<String> token = tokenizer.getTokens(listClass);

        assertEquals("Api", token.get(0));
        assertEquals("Name", token.get(1));
        assertEquals("Class", token.get(2));
        assertEquals("Tokenizer", token.get(3));
    }

    @Test
    public void tokenizerNameClassFromListNameClass() {
        ApiClassNameTokenizer tokenizer = new ApiClassNameTokenizer();

        setUpListClassWithOneNameClass();
        listClass.add("ApiGoogleTrendsTest");

        List<String> token = tokenizer.getTokens(listClass);

        assertEquals("Api", token.get(0));
        assertEquals("Name", token.get(1));
        assertEquals("Class", token.get(2));
        assertEquals("Tokenizer", token.get(3));
        assertEquals("Google", token.get(4));
        assertEquals("Trends", token.get(5));
        assertEquals("Test", token.get(6));

    }

}
