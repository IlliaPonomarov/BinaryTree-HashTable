package HashTables;

import java.util.LinkedList;

public class ChainHash {
    final static int SIZE = 1000;

    LinkedList<HTObject>[] hashtable = new LinkedList[SIZE  +1];

    class HTObject {
        Integer key;
        String value;

        public HTObject(Integer key, String value) {
            this.key = key;
            this.value = value;
        }

        public Integer getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public HTObject(){}
    }

    public ChainHash() {
        for (int i = 0; i < SIZE + 1; i++)
            hashtable[i] = null;
    }


    public int hashFunction(Integer key){
        int hash = key.hashCode();
        return (hash & 0x7FFFFFFF) % SIZE;
    }

    public void insertHash(Integer key, String value){
        int index = hashFunction(key);
//        HTObject linkNext = new HTObject(key);
//        linkNext.next = null;
//
//        System.out.println("index = " + index);
//
//
//        if (hashtable[index] == null){
//            chainHash.head = linkNext;
//            hashtable[index] = chainHash.head;
//            hashtable[index].next = null;
//        }
//        else if (hashtable[index] != null && hashtable[index].next == null && chainHash.head != null){
//
//            HTObject last = chainHash.head;
//            hashtable[index] = new HTObject(key);
//            hashtable[index].next = null;
//
//            while (last.next != null)
//                last = last.next;
//
//            last.next = linkNext;
//        }
//        return chainHash;
        LinkedList<HTObject> htObjects = hashtable[index];

        if (htObjects == null){
            htObjects = new LinkedList<HTObject>();
            htObjects.add(new HTObject(key, value));
            hashtable[index] = htObjects;
        }
        else{
            for (int i = 0; i < htObjects.size(); i++) {

                if (hashtable.length >= )

                if (htObjects.get(i).key.equals(key))
                    htObjects.get(i).value = value;return;
            }
            htObjects.add(new HTObject(key, value));
            hashtable[index] = htObjects;
        }
    }

    public String deleteByKey(int key){

        int index = hashFunction(key);
        if (hashtable != null){
            LinkedList<HTObject> htObjects = hashtable[index];
            for (int i = 0; i < htObjects.size(); i++)
                if (htObjects.get(i).key.equals(key)) {
                    htObjects.get(i).key = null;
                    htObjects.get(i).value = null;
                    System.out.println("Delete was successful");
                }
        }else
            return null;
        return null;
    }

    public String getValueByKey(int key){

        int index = hashFunction(key);
        if (hashtable != null) {

            LinkedList<HTObject> htObjectLinkedList = hashtable[index];
            for (int i = 0; i < htObjectLinkedList.size(); i++) {
                if (htObjectLinkedList.get(i).key.equals(key))
                    return htObjectLinkedList.get(i).value;
            }
        }

        return null;
    }

    public void  resize(){
        LinkedList<HTObject>[] newList = new LinkedList[]{};
    }



}

