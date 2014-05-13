

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

}
