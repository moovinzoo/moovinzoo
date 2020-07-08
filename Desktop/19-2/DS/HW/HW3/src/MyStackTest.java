import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>();
        String inputFilePath;
        if(System.getProperty("file.separator").equals("\\"))
            inputFilePath = Paths.get("testinput", "input.text").toString();
        else
            inputFilePath = "testinput/input2.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            String line = null;
            System.out.println("Operate Value\tStack");
            System.out.println("---------------------");
            while ((line = reader.readLine()) != null) {
                System.out.println(line + "\t");
                if (line.startsWith("PUSH")) {
                    String value = line.split(" ")[1];
                    stack.push(value);
                    System.out.println(stack);
                } else if (line.equals("POP")) {
                    System.out.print(stack.pop());
                    System.out.print("\t");
                    System.out.println(stack);
                } else if (line.equals("LENGTH")) {
                    System.out.println(stack.length() + "\t" + stack);
                } else if (line.equals("CLEAR")) {
                    stack.clear();
                    System.out.println("-\t" + stack);
                } else if (line.equals("PRINT")) {
                    System.out.println("-\t" + stack);
                } else if (line.equals("TOPVALUE")) {
                    System.out.println(stack.topValue() + "\t" + stack);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
