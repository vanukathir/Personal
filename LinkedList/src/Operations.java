public class Operations {

    Node list;
    Node insertBegin(int data){
        Node newNode = new Node(data);
        if(list == null){
            return newNode;
        }
        newNode.next = list;
        return newNode;
    }
    Node insertLast(int data){
        Node newNode = new Node(data);
        Node itr = list;
        while(list.next != null){
            list = list.next;
        }
        list.next = newNode;
        return itr;
    }

    Node insertMiddle(int data){
        Node newNode = new Node(data);
        Node onePtr,twoPtr;
        onePtr = list; twoPtr = list.next;
        while(twoPtr !=null && twoPtr.next != null){
            onePtr = onePtr.next;
            twoPtr = twoPtr.next.next;
        }
        newNode.next = onePtr.next;
        onePtr.next = newNode;
        return list;
    }

    void printList(Node list){
        while(list!=null){
            System.out.print(list.data +"-->" );
            list = list.next;
        }
        System.out.println("null");
    }

    Node insertAfternth(int data,int pos){
        Node newNode = new Node(data);
        Node itr = list;
        while(pos > 1 && list !=null){
            list = list.next;
            pos--;
        }
        newNode.next = list.next;
        list.next = newNode;
        return itr;
    }

    Node deleteFirst(Node list){
        Node node = list;
        list = list.next;
        node.next = null;
        return list;
    }

    Node deleteLast(){
        Node itr = list;
        while(itr.next.next !=null){
            itr = itr.next;
        }
        itr.next = null;
        return list;
    }

    Node deleteMiddle(){
        Node onePtr = list,twoPtr = list;
        while(twoPtr != null && twoPtr.next !=null ){
            onePtr = onePtr.next;
            twoPtr = twoPtr.next.next;
        }
        twoPtr = onePtr.next;
        onePtr.next = twoPtr.next;
        return list;
    }

    public static void main(String[] args){
        Operations obj = new Operations();
        obj.list = obj.insertBegin(2);
        obj.list = obj.insertLast(3);
        obj.list = obj.insertBegin(1);
        obj.list = obj.insertLast(10);
        obj.list = obj.insertMiddle(13);

        obj.list = obj.insertMiddle(4);
        obj.list = obj.insertAfternth(7,6);
        obj.printList(obj.list);
        obj.list = obj.deleteFirst(obj.list);
        obj.list = obj.deleteLast();
        obj.list = obj.deleteMiddle();
        obj.printList(obj.list);
    }
}
