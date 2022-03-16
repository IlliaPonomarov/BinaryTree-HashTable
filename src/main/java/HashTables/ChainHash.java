package HashTables;

import org.w3c.dom.html.HTMLObjectElement;

import java.util.*;
import java.util.LinkedList;

public class ChainHash {
    final static int CAPACITY = 1000;

    public static LinkedList<HTObject>[] hashtable = new LinkedList[CAPACITY + 1];

    class HTObject {
        private Integer key;
        private String value;

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

        public HTObject() {
        }
    }

    public ChainHash() {
        for (int i = 0; i < CAPACITY + 1; i++)
            hashtable[i] = null;
    }


    public int hashFunction(Integer key) {
        return (key.hashCode() & 0x7FFFFFFF) % CAPACITY;
    }

    public void insertHash(Integer key, String value) {
        int index = hashFunction(key);
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

    public void deleteByKey(int key) {
        int index = hashFunction(key);
        LinkedList<HTObject> items = hashtable[index];

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getKey().equals(key) && items != null){
                items.remove(items.get(i));
                return;
            }else
                return;
        }


    }

    public String getValueByKey(int key) {

        int index = hashFunction(key);
        if (hashtable != null) {

            LinkedList<HTObject> htObjectLinkedList = hashtable[index];
            for (int i = 0; i < htObjectLinkedList.size(); i++) {
                if (htObjectLinkedList.get(i).getKey().equals(key)) {
                    return htObjectLinkedList.get(i).value;
                }
            }
        }

        return null;
    }

    public LinkedList<HTObject>[] resize() {
        int sizeOfnewTable = hashtable.length * 2;
        LinkedList<HTObject>[] new_hastable = new LinkedList[sizeOfnewTable];
        LinkedList<HTObject>[] old_hastable = hashtable;

        hashtable = new LinkedList[sizeOfnewTable];

        for (int i = 0; i < hashtable.length; i++)
            hashtable[i] = null;


        for (LinkedList<HTObject> objects: old_hastable) {
            if (objects != null){
                insertHash(objects.get(0).getKey(), objects.get(0).getValue());
                if (objects.get(0).getKey().equals(objects.get(0).key) && objects.get(0) != null && objects.size() > 1)
                    for (int i = 0; i < objects.size(); i++)
                        insertHash(objects.get(i).getKey(), objects.get(i).getValue());
            }
        }

        System.out.println(hashtable.length);


        return new_hastable;
    }

    public void getAll() {

        for (LinkedList<HTObject> objects: hashtable)
            if (objects != null) {
                System.out.println(objects.get(0).getKey() + "\t" + objects.get(0).getValue());
                if (objects.get(0).getKey().equals(objects.get(0).key) && objects.get(0) != null)
                    if (objects.size() > 1) {
                        for (int j = 0; j < objects.size(); j++)
                            if (j < objects.size())
                                System.out.print("" + objects.get(j).getValue() + "->");
                            else if (j == objects.size())
                                System.out.print("" + objects.get(j).getValue());
                    }
                System.out.println("\n");
            }
    }

    }




