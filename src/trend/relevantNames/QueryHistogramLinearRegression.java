

package trend.relevantNames;

import org.apache.commons.math3.stat.regression.SimpleRegression;


public class QueryHistogramLinearRegression {
    
     public double[] linearRegression(QueryHistogram queryHistogram) {
        
        SimpleRegression simpleRegression = new SimpleRegression();
        
        for (int i = 1; i <= 30; i++) {
            simpleRegression.addData(i, queryHistogram.getHistogram()[i-1]);
        }
        
        double[] line = new double[30];
        
        for (int i = 1; i <= 30; i++) {
            line[i-1] = simpleRegression.predict(i);
        }
        
        return line;
    }
    
    public double getSlope(QueryHistogram queryHistogram) {
        double[] line = getLine(queryHistogram);
        
        double first = line[0];
        double last = line[line.length - 1];
        
        return (last - first) / line.length;
    }
    
    public String getTrend(QueryHistogram queryHistogram) {
        if (this.getSlope(queryHistogram) == 0) {
            return "Equal";
        }
        return this.getSlope(queryHistogram) > 0 ? "Increasing" : "Decreasing";
    }

    private double[] getLine(QueryHistogram queryHistogram) {
        return this.linearRegression(queryHistogram);
    }
    
    public Boolean isEqual(QueryHistogram queryHistogram) {
        return this.getSlope(queryHistogram) == 0;
    }
    
    public Boolean isDecreasing(QueryHistogram queryHistogram) {
        return this.getSlope(queryHistogram) == -1;
    }
    
    public Boolean isIncreasing(QueryHistogram queryHistogram) {
        return this.getSlope(queryHistogram) == 1;
    }
    
}
