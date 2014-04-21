package corest.rank;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ClassFileReaderTests {

    @Test
    public void testReadFile() throws IOException {
        ClassFileReader reader = new ClassFileReader();
        ArrayList<String> lines = new ArrayList<>();
        lines.add("package corest.rank;");
        lines.add("");
        lines.add("public class ReadClass {");
        lines.add("}");
        assertEquals(lines, reader.read(new File("test/corest/rank/ReadClass.java")));
    }
}
