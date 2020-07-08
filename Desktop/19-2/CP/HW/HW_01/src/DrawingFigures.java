import java.util.Scanner;

public class DrawingFigures {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size : ");
        int size = sc.nextInt();

        assert(size >= 1 && size <= 6): "size out";

        Draw(size);
    }

    static void Draw (int size) {
        String pre = "////";
        String mid = "****";
        String post = "\\\\\\\\";
        final int max = 6;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < max-1-i; j++)
                System.out.print(pre);
            for (int j = 0; j < i; j++)
                System.out.print(mid+mid);
            for (int j = 0; j < max-1-i; j++)
                System.out.print(post);
            System.out.println();
        }
    }
}