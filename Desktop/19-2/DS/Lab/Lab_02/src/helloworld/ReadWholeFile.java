package helloworld;

import java.io.*;

public class ReadWholeFile {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("sample-input.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}
