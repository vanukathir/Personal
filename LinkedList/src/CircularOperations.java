public class CircularOperations {

    Node insertBegin(Node node,int data){
        Node newNode = new Node(data);
        if(node == null){
            newNode.next = newNode;
            return newNode;
        }
        Node itr = node;
        while(itr.next != node){
            itr = itr.next;
        }
        newNode.next = node;
        itr.next = newNode;
        return newNode;
    }

    Node insertLast(Node node,int data){
        Node newNode = new Node(data);
        Node itr = node;
        while(itr.next !=node){
            itr=  itr.next;
        }
        newNode.next = node;
        itr.next = newNode;
        return node;
    }

    Node insertMiddle(Node node ,int data){
        Node newNode = new Node(data);
        Node onePtr = node, twoPtr = node.next, itr=  node;
        while(twoPtr != node && twoPtr.next != node){
            onePtr = onePtr.next;
            twoPtr = twoPtr.next.next;
        }
        newNode.next = onePtr.next;
        onePtr.next = newNode;
        return node;
    }

    Node deleteFirst(Node node){
        Node itr = node;
        while(itr.next != node){
            itr = itr.next;
        }
        node = node.next;
        itr.next = node;
        return node;
    }

    Node deleteLast(Node node){
        Node itr = node;
        while(itr.next !=node && itr.next.next!=node){
            itr = itr.next;
        }
        itr.next = node;
        return node;
    }

    Node deleteMiddle(Node node) {
        Node onePtr = node,twoPtr= node.next, itr = node;
        while (twoPtr!=null && twoPtr.next!=node && twoPtr.next.next != node){
            twoPtr = twoPtr.next.next;
            onePtr = onePtr.next;
        }
        itr = onePtr.next;
        onePtr.next = itr.next;
        return node;
    }
    public static void main(String[] args){
        CircularOperations obj = new CircularOperations();
        Node node = null;
        node = obj.insertBegin(node,4);
        node = obj.insertBegin(node,3);
        node = obj.insertBegin(node,2);
        node = obj.insertBegin(node,1);
        node = obj.insertLast(node,30);
        node = obj.insertLast(node,40);
        node = obj.insertLast(node,50);
        node = obj.insertLast(node,60);
        node = obj.insertMiddle(node,15);
        node = obj.insertMiddle(node,17);
        obj.printCircularList(node);

        System.out.println("Deletion of circular list");
        node = obj.deleteFirst(node);
        node = obj.deleteLast(node);
        node = obj.deleteMiddle(node);
        obj.printCircularList(node);
    }

    void printCircularList(Node node){
        Node itr = node;
        while(node.next != itr){
            System.out.print(node.data +"-->");
            node = node.next;
        }
        System.out.println(node.data+"<->");
    }
}
