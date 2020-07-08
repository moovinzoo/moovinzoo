package PascalTriangle;

public class PascalTriangle {
    public static int computeBinomialCoef(int n, int k) {
        
        if (k == 0 || k == n) {
            return 1;
        } else {
            return computeBinomialCoef(n-1, k-1) + computeBinomialCoef(n-1, k);
        }
    }

    public static void drawPascalTriangle(int n) {
        for (int i = 0; i <= n; i++) {
            int j = 0;
            System.out.print(computeBinomialCoef(i, j));

            for (j = 1; j <= i; j++) {
                System.out.print(" " + computeBinomialCoef(i, j));
            }

            System.out.println();
        }
    }
}
