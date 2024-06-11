import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class QueueWithLinkedList {
    public static void main(String[] args){
        QueueWithLinkedList ql = new QueueWithLinkedList();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.offer(2);
        queue.poll();
        queue.remove();
        System.out.println("queue:"+ Arrays.toString(queue.stream().toArray()));
    }
}
