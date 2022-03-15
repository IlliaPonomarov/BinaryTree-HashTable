package HashTables;

public class ChainHash {
    Node head;
    class Node{
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
            next = null;
        }

    }
}
