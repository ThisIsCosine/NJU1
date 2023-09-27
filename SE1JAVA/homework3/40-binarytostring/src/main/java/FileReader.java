

import java.io.*;


public class FileReader {
    public String readFile(String filePath) throws IOException{

            File file = new File(filePath);
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            inputStream.read(bytes);
            int a = 2;
            return new String(bytes);



        //TODO
        //OJ version:java 8
    }
}
