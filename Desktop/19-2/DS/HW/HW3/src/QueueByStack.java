public class QueueByStack<E> {
    MyStack<E> stack1 = new MyStack<>(); // Main
    MyStack<E> stack2 = new MyStack<>(); // Sub

    /** Put "it" in queue */
    public void enqueue(E it) {
        // Todo: implement enqueue using the given stacks
        this.stack2.clear(); // clear before use
        this.stack2.push(it);

        // Main(old) -> Sub(empty)
        while (this.stack1.length() > 0) {
            this.stack2.push(this.stack1.pop());
        }

        // Sub(Main+new item) -> Main(empty)
        this.stack1.clear(); // clear before use
        while (this.stack2.length() > 0) {
            this.stack1.push(this.stack2.pop());
        }
    }
    /** Remove and return front value */
    public E dequeue() {
        //Todo: implement dequeue using the given stacks

        this.stack2.clear(); // clear before use

        // Main(old) -> Sub(empty)
        while (this.stack1.length() > 0) {
            this.stack2.push(this.stack1.pop());
        }

        E byeItem = this.stack2.pop(); // item to be return

        // Sub(Main-byeItem) -> Main(empty)
        this.stack1.clear(); // clear before use
        while (this.stack2.length() > 0) {
            this.stack1.push(this.stack2.pop());
        }

        return byeItem;
    }

}
