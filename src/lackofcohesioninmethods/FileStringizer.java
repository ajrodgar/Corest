package lackofcohesioninmethods;

import java.io.*;

public class FileStringizer {
    public static String fileToString(File file) {
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
        }finally{
           try{                   
              if( null != fr ){  
                 fr.close();    
              }
           }catch (Exception e2){
              e2.printStackTrace();
           }
        }
        return fileString;
    }
    
    
    public static String format(String file){
            String formatedFile = file.toString();
            formatedFile = formatedFile.replace("{","{\n");
            formatedFile = formatedFile.replace(";",";\n");
            formatedFile = formatedFile.replace("}","\n}\n");
            return formatedFile.replace(" ", "");
    }
}
