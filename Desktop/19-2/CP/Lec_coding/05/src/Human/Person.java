package Human;

public class Person {
    // public, protected, default, private
    // public - accessible all the other class
    // default - accessible within the package
    // protected - accessible within the package and subclasses
    // range : protected > default
    // only matter when you use different packages
    // Package P1 => class A{int a, protected int b}
    // Package P2 => class B extends A{ a X, b O reachable}
    private int age;
    private String name;
    // when something is defined as private, it is not inherited.
        // But the memory has been allocated.

    public Person() {
        name = "ToBeFilled";
        printInfo(); // non-static object function
        print(); // static function
    }
    public void printInfo() { // Do not override.
        System.out.println("Name: " + name + ", Age: " + age);
    }

    static public void print() {
        System.out.println("I am a parent");
    }
}

