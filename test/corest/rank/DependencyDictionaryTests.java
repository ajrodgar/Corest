package corest.rank;

import java.io.File;
import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DependencyDictionaryTests {
    
    @Test
    public void testClassIsInProject() {
        ArrayList<File> files = new ArrayList<>();
        files.add(new File("test/corest/rank/TestClass.java"));
        DependencyDictionary dictionary = new DependencyDictionary(files);
        assertTrue(dictionary.isProjectClass("TestClass"));
    }
}