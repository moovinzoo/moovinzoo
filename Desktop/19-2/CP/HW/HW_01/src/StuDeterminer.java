import java.util.Scanner;

public class StuDeterminer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int year = sc.nextInt();
            String word;
            switch (year) {
                case 1:
                    word = "Year 1 student is freshman.";
                    break;
                case 2:
                    word = "Year 2 student is sophomore.";
                    break;
                case 3:
                    word = "Year 3 student is junior.";
                    break;
                case 4:
                    word = "Year 4 student is senior.";
                    break;
                default:
                    word = null;
            }

            if (word == null) {
                System.out.println("There is no 5 year in university.");
            } else {
                System.out.println(word);
            }
        }
    }
}
