public class QueueByStackTest {
    public static void main(String[] args) {
        QueueByStack<String> queue = new QueueByStack<>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.nio.file.Paths;
//
//public class QueueByStackTest {
//    public static void main(String[] args) {
//        QueueByStack<String> queue = new QueueByStack<>();
//        String inputFilePath;
//        if(System.getProperty("file.separator").equals("\\"))
//            inputFilePath = Paths.get("testinput", "input.txt").toString();
//        else
//            inputFilePath = "testinput/input3.txt";
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
//            String line = null;
//            System.out.println("Operate Value\tQueue");
//            System.out.println("---------------------");
//            while ((line = reader.readLine()) != null) {
//                System.out.print(line + "\t");
//                if (line.startsWith("ENQUEUE")) {
//                    String value = line.split(" ")[1];
//                    queue.enqueue(value);
//                    System.out.println(queue);
//                } else if (line.equals("DEQUEUE")) {
//                    System.out.print(queue.dequeue());
//                    System.out.print("\t");
//                    System.out.println(queue);
//                } else if (line.equals("PRINT")) {
//                    System.out.println("-\t" + queue);
//                }
//            }
//            reader.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}