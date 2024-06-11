import java.util.ArrayList;
import java.util.List;

public class QueueWithArray {

    int index;
    int size = 5;
    public static void main(String[] args){
        QueueWithArray obj = new QueueWithArray();
        obj.index = 0;
        ArrayList<Integer> queue = new ArrayList<>();
        obj.enqueue(queue, 1);
        obj.enqueue(queue, 2);
        obj.enqueue(queue, 3);
        obj.enqueue(queue, 4);
        obj.enqueue(queue, 5);
        obj.enqueue(queue, 6);
        System.out.println("########################");
        obj.printQueue(queue);
        System.out.println("########################");
        obj.dequeue(queue);
        obj.dequeue(queue);
        obj.printQueue(queue);
    }

    void dequeue(List queue){
        int ptr = index-1;
        if(ptr >= 0 ) {
            queue.remove(ptr);
            index--;
        }else{
            System.out.println("queue is empty");
        }
    }

    void printQueue(List queue){
        int ptr = index-1;
        while(ptr >=0 ){
            System.out.println(queue.get(ptr));
            ptr--;
        }
    }

    void enqueue(List queue, int data){
        if(index < size) {
            queue.add(index, data);
            index++;
        }else {
            System.out.println("queue is full");
            return;
        }
    }
}
