import java.io.*;

public class GetFiles {

    public static void main(String ss[]) {
        File dir = new File("C:/1");
        String[] children = dir.list();
        if (children == null) {
            
        } else {
            for(int i = 0; i < children.length; i++) {
                String filename = children[i];
                File fd = new File(filename);
                if (fd.isDirectory()) {
                    System.out.println("DIR  ====>" + filename);
                } else {
                    System.out.println("FILE ====>" + fd.getAbsolutePath() + " =====" + filename);
                }
            }
        }
    }
}
