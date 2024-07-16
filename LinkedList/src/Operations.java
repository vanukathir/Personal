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
        obj.list = obj.insertBegin(6);
        obj.list = obj.insertLast(2);
        obj.list = obj.insertBegin(3);
        obj.list = obj.insertLast(6);
        obj.list = obj.insertMiddle(4);

        obj.list = obj.insertMiddle(5);
        obj.list = obj.insertAfternth(6,6);
        obj.printList(obj.list);
      /*  obj.list = obj.deleteFirst(obj.list);
        obj.list = obj.deleteLast();
        obj.list = obj.deleteMiddle();
        obj.printList(obj.list);*/


        // remove elemetns recursively;
        obj.list = obj.removeElements(obj.list,6);
        obj.printList(obj.list);
    }

    public Node removeElements(Node head, int val) {
        if(head == null)
            return head;
        else if(head.next!=null && head.next.data == val){
            head.next = head.next.next;
            Node node = removeElements(head, val);
        }else{
            Node node = removeElements(head.next, val);
        }

        if(head != null && head.data == val){
            head = head.next;
        }
        return head;
    }


}
