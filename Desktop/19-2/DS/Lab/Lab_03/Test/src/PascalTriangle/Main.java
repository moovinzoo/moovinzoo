package PascalTriangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            String command = sc.next();

            if ("binomial".equals(command)) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                PascalTriangle.computeBinomialCoef(n, m);

            } else if ("draw".equals(command)) {
                int n = sc.nextInt();
                PascalTriangle.drawPascalTriangle(n);

            } else {
                throw new AssertionError("Invalid input!");
            }
        }
    }

}