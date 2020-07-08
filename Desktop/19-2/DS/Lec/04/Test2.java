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

    Student(String name) {
        name = name;
        // parameter considered as local variable
        // :: taking the memory-stack
        // :: attributes taking the memory-heap
        // :: Priority;  stack > heap
    } // Not gonna assign parameter string to attribute

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

}
public class Test2 {
    public static void main(String[] args) {
        Student st1 = new Student("Kitae");
        System.out.print(st1.name);
    }

}
