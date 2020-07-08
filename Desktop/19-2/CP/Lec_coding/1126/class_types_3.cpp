class A();
class B();

int main(int argc, char *argv[])
{
    //class types
    
    int* x;
    long long y;

    y = (long long) x; // possible
    x = (int*) y; // possible
    // Freedom? in many case : 실수로 이어진다.
    // cpp doesn't want this result.
    // What types of casting 인지 명시하는 것이 좋다.


    return 0;
}
