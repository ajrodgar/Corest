package lackofcohesioninmethods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileStringizer {

    public static String fileToString(File file) {
        FileReader fr = null;
        BufferedReader br = null;
        String fileString = "";

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = deleteComments(linea);
                fileString += linea;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deleteMultiLineComments(fileString);
    }

    private static String format(String source) {
        String formatedFile = source.toString();
        formatedFile = formatedFile.replace("{", "{\n");
        formatedFile = formatedFile.replace(";", ";\n");
        formatedFile = formatedFile.replace("}", "\n}\n");
        return formatedFile;
    }

    public static String[] prepareFile(File file) {
        String code = format(FileStringizer.fileToString(file));
        return code.split("\n");
    }
    
    private static String deleteComments(String line){
        if(line.contains("//")) return line.substring(0, line.indexOf("//"));
        return line;
    }
    
    private static String deleteMultiLineComments(String source){
        while(source.contains("/*")){
            int start = source.indexOf("/*");
            int end = source.indexOf("*/") + 2;
            source = source.substring(0, start) + source.substring(end, source.length());
        }
        return source;
    }
}