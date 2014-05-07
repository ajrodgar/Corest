package lackofcohesioninmethods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileStringizer {

    public static String fileToString(File file){
        FileReader fr = null;
        BufferedReader br = null;
        String fileString = "";

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                fileString += linea+"\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileString;
    }

    private static String format(String source) {
        String formatedFile = source.toString();
        formatedFile = formatedFile.replace("{", "{\n");
        formatedFile = formatedFile.replace(";", ";\n");
        formatedFile = formatedFile.replace("}", "\n}\n");
        return formatedFile;
    }

    public static String[] prepareFile(String code) {
        code = deleteMultiLineComments(code);
        code = format(code);
        String[] lines = code.split("\n");
        for (int i = 0; i < lines.length; i++) {
            lines[i] = deleteComments(lines[i]);
            System.out.println(lines[i]);
        }
        return lines;
    }
    
    private static String deleteComments(String line){
        if(line.contains("//")) return "";
        if(line.contains("@")) return "";
        return line;
    }
    
    private static String deleteMultiLineComments(String source){
        while(source.contains("/*")){
            int start = source.indexOf("/*");
            int end = source.indexOf("*/") + 2;
            source = source.substring(0, start) +"\n" + source.substring(end, source.length());
        }
        return source;
    }
}