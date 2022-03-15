package HashTables;

public class ChainHash {
    final static int SIZE = 1000;
    Node[] hashtable = new Node[SIZE + 1];
    Node head;

    class Node{
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
            next = null;
        }
    }

    public int hashFunction(int key){
        return key % SIZE;
    }

    public ChainHash insertHash(int key, ChainHash chainHash){
        int hashFunc = hashFunction(key);
        Node node = new Node(key);
        Node linkNext = new Node(key);
        linkNext.next = null;


        if (hashtable[hashFunc] == null){
            chainHash.head = linkNext;
            hashtable[hashFunc] = chainHash.head;
            hashtable[hashFunc].next = null;
        }
        else if (hashtable[hashFunc] != null && hashtable[hashFunc].next == null && chainHash.head != null){

            Node last = chainHash.head;
            hashtable[hashFunc] = new Node(key);
            hashtable[hashFunc].next = null;

            while (last.next != null)
                last = last.next;

            last.next = linkNext;
        }
        return chainHash;
    }


    public int searchByKeyHash(int key){

        int index = hashFunction(key);

        while (hashtable[index] != null){

            if (hashtable[index] == null)
                return -1;

            if (hashtable[index].key == key)
                return index;

            else if (hashtable[index].next != null)
                hashtable[index] = hashtable[index].next;

            else if (hashtable[index].next == null)
                break;




        }
        return 0;
    }

    public void printHash(){

        Node node = null;
        for (int i = 0; i < SIZE; i++) {
            if (hashtable[i] != null){
                node = hashtable[i];

                if (hashtable[i].next != null){
                    while (node.next != null){
                        System.out.print(node.key + " ");
                        System.out.print("->");
                        node = node.next;
                    }
                    System.out.print(node.key  +" ");
                }else {
                    System.out.print(hashtable[i].key + " ");
                }
                System.out.println(node.key + " ");
            }
        }
    }


}

