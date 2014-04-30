package main;

import analyzer.MyResult;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws Exception {
        MainController test = new MainController("https://github.com/ajrodgar/Corest.git");
        ArrayList<MyResult> results = test.analyzeAll("AnalyzerTest");
        
        for (MyResult myResult : results) {
            System.out.println("\nResult: "+myResult.getText());
        }

    }
}
