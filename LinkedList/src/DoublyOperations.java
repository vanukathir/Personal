public class DoublyOperations {

    DoublyNode insertBegin(DoublyNode node, int data){
        DoublyNode newNode = new DoublyNode(data);
        newNode.next = node;
        newNode.prev = null;
        if(node!=null) {
            node.prev = newNode;
        }
        node = newNode;
        return node;
    }

    DoublyNode insertLast(DoublyNode node,int data){
        DoublyNode newNode = new DoublyNode(data);
        DoublyNode itr = node;
        while(itr.next != null){
            itr = itr.next;
        }
        newNode.prev = itr;
        itr.next = newNode;
        return node;
    }

    DoublyNode insertMiddle(DoublyNode node,int data){
        DoublyNode newNode = new DoublyNode(data);
        DoublyNode onePtr = node,twoPtr = node;
        while(twoPtr!= null && twoPtr.next != null){
            onePtr = onePtr.next;
            twoPtr = twoPtr.next.next;
        }
        newNode.next = onePtr;
        newNode.prev = onePtr.prev;
        onePtr.prev.next = newNode;
        onePtr.prev = newNode;
        return node;
    }

    DoublyNode deleteFirst(DoublyNode node){
        if(node!=null) {
            node = node.next;
            node.prev = null;
            return node;
        }
        else
            return node;
    }

    DoublyNode deleteLast(DoublyNode node){
        DoublyNode itr = node;
        while(node.next!=null){
            node = node.next;
        }
        node.prev.next = null;
        node.prev = null;
        return itr;
    }
    DoublyNode deleteMiddle(DoublyNode node){
        DoublyNode onePtr = node,twoPtr = node;
        while(twoPtr!= null && twoPtr.next !=null){
            onePtr = onePtr.next;
            twoPtr = twoPtr.next.next;
        }
        System.out.println("deletedNode:"+onePtr.data);
        onePtr.next.prev = onePtr.prev;
        onePtr.prev.next = onePtr.next;
        return node;
    }
    public static void main(String[] args){
        DoublyOperations obj = new DoublyOperations();
        DoublyNode node = null;
        node = obj.insertBegin(node,5);
        node = obj.insertBegin(node,4);
        node = obj.insertLast(node,30);
        node = obj.insertLast(node,45);
        node = obj.insertMiddle(node,15);
        node = obj.insertMiddle(node,10);
        obj.printReversePrev(node);
        obj.printDoublyList(node);
        System.out.println("Deletion");
        node = obj.deleteFirst(node);
        node = obj.deleteMiddle(node);
        node = obj.deleteLast(node);
        obj.printDoublyList(node);

    }

    void printReversePrev(DoublyNode node){
        while(node.next !=null){
            node = node.next;
        }
        while(node!=null){
            System.out.print(node.data+ "<-->");
            node = node.prev;
        }
        System.out.println("null");
    }
    void printDoublyList(DoublyNode node){
        while(node!=null){
            System.out.print(node.data+ "<-->");
            node = node.next;
        }
        System.out.println("null");
    }
}
