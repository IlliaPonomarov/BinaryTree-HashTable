package HashTables;

import org.w3c.dom.html.HTMLObjectElement;

import java.util.*;
import java.util.LinkedList;

public class ChainHash {
    final static int CAPACITY = 1000;

    public static LinkedList<HTObject>[] hashtable = new LinkedList[CAPACITY + 1];
    List<Integer> allKeys = new ArrayList<Integer>();

    class HTObject {
        Integer key;
        String value;

        public HTObject(Integer key, String value) {
            this.key = key;
            this.value = value;
            allKeys.add(key);
        }

        public Integer getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public HTObject() {
        }
    }

    public ChainHash() {
        for (int i = 0; i < CAPACITY + 1; i++)
            hashtable[i] = null;
    }


    public int hashFunction(Integer key) {
        int hash = key.hashCode();
        return (hash & 0x7FFFFFFF) % CAPACITY;
    }

    public void insertHash(Integer key, String value) {
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

        if (htObjects == null) {
            htObjects = new LinkedList<HTObject>();
            htObjects.add(new HTObject(key, value));
            hashtable[index] = htObjects;
        } else {
            for (int i = 0; i < htObjects.size(); i++) {

                if (hashtable.length == CAPACITY)
                    hashtable = resize();

                if (htObjects.get(i).getKey().equals(key)) {
                    htObjects.add(new HTObject(key, value));
                    return;
                }
            }
            htObjects.add(new HTObject(key, value));
            hashtable[index] = htObjects;

        }
    }

    public String deleteByKey(int key) {

        int index = hashFunction(key);
        if (hashtable != null) {
            LinkedList<HTObject> htObjects = hashtable[index];
            for (int i = 0; i < htObjects.size(); i++)
                if (htObjects.get(i).key.equals(key)) {
                    htObjects.remove(htObjects.get(i));
                    System.out.println("Delete was successful");
                }
        } else
            return null;
        return null;
    }

    public String getValueByKey(int key) {

        int index = hashFunction(key);
        if (hashtable != null) {

            LinkedList<HTObject> htObjectLinkedList = hashtable[index];
            for (int i = 0; i < htObjectLinkedList.size(); i++) {
                if (htObjectLinkedList.get(i).key.equals(key)) {
                    System.out.println(htObjectLinkedList.get(i).value);
                }
            }
        }

        return null;
    }

    public LinkedList<HTObject>[] resize() {
        LinkedList<HTObject>[] newList = new LinkedList[CAPACITY * 2];

        Integer key = 0, index = 0;
        for (int i = 0; i < CAPACITY * 2; i++)
            newList[i] = null;

        for (int i = 0; i < CAPACITY; i++) {
            if (hashtable[i] == null)
                continue;

            else {
                for (int j = 0; j < hashtable.length; j++) {
                    if (hashtable[j] != null) {

                        key = hashtable[j].get(0).getKey();
                        key = key.hashCode();
                        index = key % (CAPACITY * 2);

                        insertHash(key, hashtable[j].get(j).getValue());
                    }

                }
            }
        }


        return newList;
    }

    public void getAll() {

        LinkedList<HTObject> linkedList = null;
        int index  = 0;
        int i  = 0;
        for (LinkedList<HTObject> objects: hashtable) {
            if (objects != null) {
                System.out.println(objects.get(0).getKey() + "\t" + objects.get(0).getValue());
                if (objects.get(0).getKey().equals(objects.get(0).key) && objects.get(0) != null)
                    if (objects.size() > 1)
                        for (int j = 0; j < objects.size(); j++)
                            System.out.print("-> " + objects.get(j).value + "\n");
                }


            }
        }

    }




