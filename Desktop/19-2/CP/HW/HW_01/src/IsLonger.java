import java.util.Scanner;

public class IsLonger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("String : ");
        String input = sc.nextLine();
        System.out.print("Estimate length : ");
        int length = sc.nextInt();
        if (longerThan(input, length)) {
            System.out.printf("%s is longer than %d\n", input, length);
        } else {
            System.out.printf("%s is equal or shorter than %d\n", input, length);
        }
    }

    static boolean longerThan (String input, int length) {
        return (input.length() > length);
    }
}
