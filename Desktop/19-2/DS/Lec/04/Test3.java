// class attributes & methods & keyword::this & static & "=" and "=="

// class ; as Type.
// :: each individual instances are totally different.
class Student {

    String name;
    int year = 2;
    // int year;
    // :: For class attribute, even if i didn't assign a value
    // :: System put some default value in it.
    String[] courseTable = new String[5];
    int numCourse = 0;
    int idNumber; // want to assign unique number to this student.

    static int totalStudentNumber;
    // by default, it is assgined to '0', cause it is attribute of Class.
    // :: Allocate not to instance, but to class itself.

    Student(String name) {
        this.name = name;
        // when we have same name of local variable, using keyword 'this' would help.
        increaseTotalNumberStudent();
        // "This function not belong to instance" || "This action is not about individual"
        // You need to strongly sure the thinking above.
    }

    // func overriding
    Student(String n, int y) {
        name = n;
        year = y;
    }
    // with the keyword 'new', automatically constructor runs.
    // :: if, there's no constructor then default runs.
    // :: default has nothing in it. (empty)

    void addCourse (String courseName) {
        courseTable[numCourse] = courseName;
        numCourse++;

    }

    void printCourse() {
        for (int i = 0; i < numCourse; i++) {
            System.out.println(courseTable[i]);
        }
    }

    static void increaseTotalNumberStudent() {
        totalStudentNumber++;
    }

}
public class Test3 {
    public static void main(String[] args) {
        Student st1 = new Student("Kitae");
        Student st2 = new Student("Eunsoo");

        System.out.println(st2.totalStudentNumber);

        Math.random();
        // Math is not needed to call Class::Math
        // Math math = new Math(); is possible.
        // example of using not instance but by class
        
    }

}
