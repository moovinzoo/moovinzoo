import java.util.ArrayList;

public class Lab05 {
    final static int initial = 10;
    public static void main(String[] args) {

        Worker[] group = new Worker[]{new Producer(), new Consumer()};

        Scheduler<Worker> scheduler = new Scheduler<>(group);
        for(int i : range(initial)){
            Worker.workload.in(new Product());
        }
        while(!Worker.workload.isEmpty()){
            Worker worker = scheduler.schedule();
            worker.work();
            scheduler.delay();
            worker.report();
        }
    }
    private static ArrayList<Integer> range(int N){
        ArrayList<Integer> out = new ArrayList<>(N);
        for(int i = 0 ; i < N; i++) {
            out.add(i);
        }
        return out;
    }
}
class Scheduler<T>{
    private static final int waitms = 300;
    private T[] group;
    Scheduler(T[] array){
        group = array;
    }
    T schedule(){
        int sample = (int)(Math.random() * group.length);
        return group[sample];
    }
    void delay(){
        try {
            Thread.sleep(waitms);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
abstract class Worker {
    final static Product work = new Product();
    static WorkQueue<Product> workload =  new WorkQueue<>();

    Worker(){
        id = numWorkers;
        numWorkers++;
        verb = "work";
    }
    abstract void work();

    String verb;
    static int numWorkers = 0;
    public int id;

    void report(){
        for(int i = 0; i < Worker.workload.size() + 300; i++) {
            System.out.print("\b");
        }
        System.out.print(work + " : " + Worker.workload);
        System.out.print(" | [" );
        for(int i = 0; i < workload.size(); i++){
            System.out.print(">");
        }
        System.out.print("]  |  " );
        System.out.print(id + "-th Worker(" + this.getClass().getName() + ") " + this.verb + "s " + work);
    }
}
class Producer extends Worker {
    Producer(){
        verb = "produce";
    }
    @Override
    void work(){
        workload.in(new Product());
    }
}
class Consumer extends Worker {
    Consumer(){
        verb = "consume";
    }
    @Override
    void work() {
        if(workload.isEmpty()) return;
        workload.out();
    }
}
class Product{
    private static final String product = "Food";
    @Override
    public String toString() {
        return product;
    }
}
class WorkQueue<E>{
    ArrayList<E> data = new ArrayList<>();
    void in ( E elem){
        data.add(elem);
    }
    E out(){
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return data.remove(0);
    }
    boolean isEmpty(){
        return data.isEmpty();
    }
    int size(){
        return data.size();
    }
    @Override
    public String toString() {
        return Integer.toString(data.size());
    }
}