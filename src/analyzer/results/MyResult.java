
package analyzer.results;

public class MyResult {
   String analyzer;
   String reference;
   Object result;

    public MyResult(String text, String reference, Object result) {
        this.analyzer = text;
        this.result = result;
        this.reference = reference;
    }


    public String getAnalyzer() {
        return analyzer;
    }

    public String getReference() {
        return reference;
    }
    
    public Object getResult() {
        return result;
    }
    
   
   
    
}
