package helloworld;

import java.io.*;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        OutputStream os = new FileOutputStream("sample-output.txt");
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("Hello Java!");
        bw.close();
    }
}
