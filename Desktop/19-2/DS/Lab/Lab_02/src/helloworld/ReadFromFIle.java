package helloworld;

import java.io.*;

public class ReadFromFIle {
    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("sample-input.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String input = br.readLine();
        System.out.println("File input: " + input);
    }
}
