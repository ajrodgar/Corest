package corest.projectanalyzer.javaprojectanalyzer.cyclomaticcomplexity;

import corest.projectanalyzer.javaprojectanalyzer.Analysis;
import java.util.*;
import corest.projectanalyzer.javaprojectanalyzer.JavaProjectAnalyzer;

public class AnalyzerCyclomaticComplexity implements JavaProjectAnalyzer {

    private final String[] keywords = {"if", "else", "while", "case",
        "for", "switch", "do", "foreach",
        "&&", "||", "?", "catch", "default",
        "continue", "goto"};
    private String className;
    private int complexity;
    private String words;
    private boolean coment;
    private StringTokenizer fileContentFormatted;

    public AnalyzerCyclomaticComplexity() {
        this.complexity = 1;
        this.coment = false;
    }

    public int getComplexity() {

        while (fileContentFormatted.hasMoreTokens()) {
            words = fileContentFormatted.nextToken();
            for (String keyword : keywords) {

                if (!coment) {

                    if (words.contains("/*")) {
                        coment = true;
                    }
                    if (words.contains("//")) {
                        coment = true;
                    }

                    if (words.contains(keyword)) {
                        complexity++;
                    }

                } else {
                    if (words.contains("*/")) {
                        coment = false;
                    }
                    if (words.contains("\n")) {
                        coment = false;
                    }
                }

            }
        }
        return complexity;
    }

    @Override
    public Analysis getAnalysis() {
        return new Analysis("CyclomaticComplexity", this.className,
                "Cylomatic Complexity: " + getComplexity());
    }

    @Override
    public void setAnalizerParameter(String... analizerParameter) {
        this.className = analizerParameter[0];
        this.fileContentFormatted = new StringTokenizer(analizerParameter[1]);
    }
}
