package corest.rank;

import java.io.File;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class RankCalculatorTests {
    
    private static RankCalculator calculator;
    
    @BeforeClass
    public static void setUp() {
        calculator = new RankCalculator();
    }
    
    @Test
    public void testGetRankOfClass() {
        assertEquals(0.5, calculator.calculateRank(new File("test/corest/rank/TestClass.java")), 0.001);
    }
    
    @Test
    public void testGetRankOfAnotherClass() {
        assertEquals(0.6, calculator.calculateRank(new File("test/corest/rank/AnotherTestClass.java")), 0.001);
    }
}