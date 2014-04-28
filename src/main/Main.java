package main;

public class Main {


    public static void main(String[] args) throws Exception {
        MainController test = new MainController("https://github.com/ajrodgar/Corest.git");
        MyResult result = test.analyze("AnalyzerTest", "example source file");

        System.out.println(result.getText());
    }
}
