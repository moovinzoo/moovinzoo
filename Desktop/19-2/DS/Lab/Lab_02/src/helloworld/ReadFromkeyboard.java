package helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadFromkeyboard {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        System.out.print("Please input some string: ");
        String input = br.readLine();
        System.out.println("Your Input: " + input);

    }
}
