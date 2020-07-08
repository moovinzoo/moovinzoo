import Human.*;

public class Test {
    public static void main(String[] args) {
//        Person s = new Student();
//        s.print();

    }
}



// In class,
    // 앞에 2개, public or (default)
// In field and method,
    // 앞에 4개, public or (default), private, protected
// about final,
    // in method,
        // Put keyword final, never allows inheritance.
    // in attribute,
        // For any fo the member variable, it means that initialize a certain value and never change this value.

//class CPStudent extends Student {
//    int experiences;
//    public void printInfo() {super.printInfo();}
    //void printInfo() {
//        super.super.printInfo();
        // in Java, for method, It's not allowed to touch grandparent's.
//    }
//}

// Under the assumption that I dont' have any Person Class.
// NOT Considered as a good design.
//      Good Design ; use all of the methods & fields.
class Worker extends Student {
    // Not a good way.
    // Rather, find the common things between S and W and define upper class like 'Person'
    // Cf. Inherit from multiple classes is not allowed to remove confusion
}


// Dynamic binding
    // When Java called function, when p is referencing the object class s, then p.method will implements s' method

// @Override
    // by Java knows it is explicitly overrided, then,  we can miss the mistake like simple typo.

// static
    // "Belongs to the class, others belong to object"
    // for static functions, will touch parent's ; Static binding.
    // not support to be overrided.