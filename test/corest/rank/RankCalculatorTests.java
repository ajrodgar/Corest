package corest.rank;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RankCalculatorTests {
    
    @Test
    public void testGetRankOfClass() {
        RankCalculator calculator = new RankCalculator();
        assertEquals(0.5, calculator.calculateRank("test/corest/rank/TestClass.java"), 0.001);
    }
}