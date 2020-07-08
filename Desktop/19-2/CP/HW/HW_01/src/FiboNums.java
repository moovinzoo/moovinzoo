public class FiboNums {
    public static void main(String[] args) {
//        final int max = 12;
//        for (int i = 0; i < max; i++) {
////            System.out.print(Fibonacci(i));
//            if (!(i == max - 1))
//                System.out.print(", ");
        // TODO : by un-recursive
        int fPrev = 1, fCurr = 1, fNext;
        for (int i = 0; i < 12; i++) {
            if (i == 0 || i == 1) {
                System.out.println(1);
            } else {
                fNext = fPrev + fCurr;
                System.out.println(fNext);
                fPrev = fCurr;
                fCurr = fNext;
            }
        }
    }

//    public static int Fibonacci(int n) {
//        if (n == 0 || n == 1) return 1;
//        else return (Fibonacci(n-1) + Fibonacci(n-2));
//    }
}
