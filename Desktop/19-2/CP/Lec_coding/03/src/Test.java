class Test {
    public static void main(String[] args) {

        double[] x = {1.2132, 2.124, 4.123, 2.11};

//        // for 예제 1번, MIN_VALUE 사용법
//        double max = Double.MIN_VALUE;
//        for(int i = 0; i < x.length; i++) {
//            if (x[i] > max) {
//                max = x[i];
//            }
//        }
        // for 예제 개선안, for-each 사용법
        double max = Double.MIN_VALUE;
        for(double currentValue : x) {
            if (currentValue > max) {
                max = currentValue;
            }
        }

        System.out.println(max);
    }
}
