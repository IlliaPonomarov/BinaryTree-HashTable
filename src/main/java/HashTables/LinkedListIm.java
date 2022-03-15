package HashTables;

public class LinkedListIm {
    Node head;
    static class Node{
        int key;
        public Node next;

        public Node(int key) {
            this.key = key;
            next = null;
        }
    }

    public LinkedListIm insertLinkedList(LinkedListIm linkedList, int key){
        Node linkNext = new Node(key);
        linkNext.next = null;

        if (linkedList.head == null)
            linkedList.head = linkNext;
        else {

            Node lastEl = linkedList.head;

            while (lastEl.next != null)
                lastEl = lastEl.next;

            lastEl.next = linkNext;
        }

        return linkedList;
    }

    public void print(){
        Node n = head;

        while (n != null){
            System.out.print(n.key + " ");
            n = n.next;
        }

    }
}
