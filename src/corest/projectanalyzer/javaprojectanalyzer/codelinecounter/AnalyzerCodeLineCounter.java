package corest.projectanalyzer.javaprojectanalyzer.codelinecounter;

import corest.projectanalyzer.javaprojectanalyzer.Analysis;
import corest.projectanalyzer.javaprojectanalyzer.JavaProjectAnalyzer;

public class AnalyzerCodeLineCounter implements JavaProjectAnalyzer {

    private int linesCounter;
    private int commentCounter;
    private boolean insideCommentBlock;
    private String[] contentFile;
    private String className;

    public AnalyzerCodeLineCounter() {
        this.linesCounter = 0;
        this.commentCounter = 0;
        this.insideCommentBlock = false;
    }

    private void count() {
        for (String line : contentFile) {
            linesCounter++;
            if (!insideCommentBlock) {
                if (isStartingCommentBlock(line)) {
                    commentCounter++;
                }
            }
            if (insideCommentBlock) {
                if (isFinishingCommentBlock(line)) {
                    commentCounter++;
                }
            }
        }
    }

    private int countComments() {
        return commentCounter;
    }

    private int countLines() {
        return linesCounter;
    }

    private boolean isStartingCommentBlock(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '/' && (i + 1 < line.length())) {
                switch (line.charAt(i + 1)) {
                    case ('/'):
                        return true;
                    case ('*'):
                        insideCommentBlock = true;
                        return false;
                }
            }
        }
        return false;
    }

    private boolean isFinishingCommentBlock(String line) {
        if (line.contains("*/")) {
            insideCommentBlock = false;
            return true;
        }
        return false;
    }

    @Override
    public Analysis getAnalysis() {
        count();
        return new Analysis("CodeLineCounter", this.className,
                "Total code lines: " + countLines() + "\nCommented lines: " + countComments() + "\n");
    }

    @Override
    public void setAnalizerParameter(String... analizerParameter) {
        this.className = analizerParameter[0];
        this.contentFile = analizerParameter[1].split("\n");

    }
}
