package lackofcohesioninmethods;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileStringizer {
    private static String fileToString(File file) {
        FileReader fr = null;
        BufferedReader br = null;
        String fileString="";
   
        try {
           fr = new FileReader (file);
           br = new BufferedReader(fr);   
           String linea;
           while((linea=br.readLine())!=null){               
              fileString+=linea;
           }           
        }
        catch(Exception e){
           e.printStackTrace();
        }
        return fileString;
    }
    
    
    private static String format(String file){
            String formatedFile = file.toString();
            formatedFile = formatedFile.replace("{","{\n");
            formatedFile = formatedFile.replace(";",";\n");
            formatedFile = formatedFile.replace("}","\n}\n");
            return formatedFile;
    }
    
    private static String deleteSpaces(String file){
        return file.replace(" ", "");
    }
    
    public static String[] prepareFileWithoutSpaces(File file){
        String stringFile = format(fileToString(file));
        stringFile = deleteSpaces(stringFile);
        return stringFile.split("\n");
    }
    
    public static String[] prepareFile(File file){
        String code = FileStringizer.format(FileStringizer.fileToString(file));
        return code.split("\n");
    }
}
