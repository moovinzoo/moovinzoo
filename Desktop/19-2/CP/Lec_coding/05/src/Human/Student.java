package Human;

public class Student extends Person {
    int id;
    char grade;


    public Student() {
        id = 1;
//        super(); // This is special way to call constructor of parent's.
        // If I didn't explicitly call the parent's constructor
        //      Java, little smart, when I declare a constructor of child, then automatically call parent's DEFAULT constructor.
        //      If you
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("In child: ID: " + id);
    }

    static public void print() {
        System.out.println("I am a student");
    }
}