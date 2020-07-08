int main(int argc, char *argv[])
{
    /* static_cast */
    A* = a;
    B* = b;
    b = (B*)a;
    b = static_cast<B*>(a); // how to do static_cast
    // CHECK : casting is right
    // conversion is logically making sense or not인지 검사하도록 장치하는 것.
    
    int * x;
    long long y;
    x = static_cast<int *>(y);
    // 1. usally no making sense 이런 캐스팅 is not allowed라고 안내받을 수 있다.
    // 2. 추가적으로, 캐스팅이 어디서 일어났는지 편하게 검색할 수 있다.
    // TODO : 문제가 있다, Dynamic casting이 필요한 이유
    
    Parent* p;
    // Parent* p = new Parent;
    // Parent* p = new Child;
    Child* c;
    c = static_cast<child*>(p); // Q : Is it OK? A : only sometimes
    // 스태틱 캐스트를 사용하면 그저 OK라고 안내한다.
    


    /* dynamic_cast */
    Parent* p = new Child;
    Child* c;
    c = dynamic_cast<Child*>(p); // valid
    
    Parent* p = new Parent;
    Child* c;
    c = dynamic_cast<Child*>(p); // invalid
    
    // Dynamic cast only right when inherited case
    // And also, when parent class casted to child.



    
    /* const_cast */
    const int x = 10;
    int& y = x; // y can be changed, x cannot be changed :: CONFLICT
    
    const int x = 10;
    int& y = const_cast<int&>(x); // y can be changed with x is still constant.
    y = 5;
    cout << y << endl; // 5
    cout << x; // 10

    // TODO: 이런짓을 왜 해?



    void func(int& x) {
        // 엄청길다고 치자
    }
    
    int main(int argc, char *argv[])
    {
        
        const int x = 10;
        func(x); // 원래는 불가능, const keyword를 지워야 함 원래는
        cout << x;

        const int x = 10;
        func(const_cast<int&>(x)); // x의 const 속성을 잠시 뗴어주는 역할, 이제 func에 들어갈 수 있다!
        cout << x;
    }

    
    /* reinterpret_cast */
    A* a;
    B* b;
    a = reinterpret_cast<A*>(b); // b의 address를 a에게 복사하고 싶을 떄
    // integer type read/write 단위 4byte
    // char type read/write 단위 1-2byte
    // 사용하지마. useful case를 찾은 적이 없어 교수는.



    /* 정리 */
    // 1. implicit(X) explicit(X) 하지 마
    // 2. reinterpret_cast(X) 실용성 없으니 그냥 쓰지 마.
    // 3. 1-3번 캐스팅만 적당하게 사용.
    
    return 0;
}
