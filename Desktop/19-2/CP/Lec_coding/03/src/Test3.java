import java.sql.SQLOutput;

class Test3 {
    public static void main(String[] args) {

        // Method ; removing the duplication.
        // Return single value, There is way to return multiple value, maybe in next time.
        // Not only for removing duplication but also for the key role of returning value.

        int numberPrinted = brainWash("DJ");
        System.out.print(numberPrinted);
    }

    // About generating the random value.
    static int brainWash(String name) {
        int x = (int)(Math.random() * 10);

        for (int i = 0; i < x; i++) {
            System.out.println(name + ", I like Java");
        }

        return x;
    }
}
