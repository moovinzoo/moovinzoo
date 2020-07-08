class Test2 {
    public static void main(String[] args) {

        int sum = 0;
        for (int i = 0; i <= 10; i++) {

//            if (i % 5 != 0) {
//                sum += i;
//            }

            if (i%5 == 0) continue;
            // KEYWORD::continue ; skip the rest of the code inside the {}.
            // Skip once.
            // Cf. Skip the entire for loop, use KEYWORD :: break.
            sum += i;
        }
        System.out.println(sum);
    }
}
