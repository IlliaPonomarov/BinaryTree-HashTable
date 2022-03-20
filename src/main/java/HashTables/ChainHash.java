package HashTables;

import java.util.Hashtable;
import java.util.LinkedList;

public class ChainHash {

    int capacity = 1000;
    int size;
    double loadFactory;

    public static LinkedList<HTObject>[] hashtable;

    public ChainHash(int capacity, double loadFactory) {
        this.capacity = capacity;
        this.loadFactory = loadFactory;
        hashtable = new LinkedList[capacity + 1];

        for (int i = 0; i < capacity + 1; i++)
            hashtable[i] = null;

    }

    class HTObject {
        private String key;
        private Integer value;

        public HTObject(String key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public HTObject(){}

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }

    }

    public int hashFunction(String key) {
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    public void insertHash(String key, Integer value) {

        int index = hashFunction(key);
        double loadFactor;
        LinkedList<HTObject> objects = hashtable[index];

        if(objects == null) {
            objects = new LinkedList<HTObject>();

            objects.add(new HTObject(key, value));

            hashtable[index] = objects;
        }
        else {
            for (HTObject item : objects) {
                if (item.key.equals(key)) {
                    item.value = value;
                    return;
                }
            }

            size++;
            loadFactor = (1.0 * size) / capacity;

            if (loadFactor > this.loadFactory)
                resize();


            objects.add(new HTObject(key, value));

        }

    }


    public void deleteByKey(String key) {
        int index = hashFunction(key);
        LinkedList<HTObject> items = hashtable[index];

        for (int i = index; i < items.size(); i++) {
            if (items.get(i)!= null && items.size() > 1) {
                items.remove(items.get(i));
                return;
            }else if (items.get(i) != null && items.size() == 1)
                items = null;
            return;
        }
    }

    public int getValueByKey(String key) {

        int index = hashFunction(key);
        if (hashtable != null) {

            LinkedList<HTObject> htObjectLinkedList = hashtable[index];
            for (int i = 0; i < htObjectLinkedList.size(); i++) {
                if (htObjectLinkedList.get(i).getKey().equals(key)) {
                    return htObjectLinkedList.get(i).getValue();
                }
            }
        }

        return -1;
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


        return new_hastable;

        //        int sizeOfnewTable = hashtable.length * 2;
//        LinkedList<HTObject>[] new_hastable = new LinkedList[sizeOfnewTable];
//        LinkedList<HTObject>[] old_hastable = hashtable;
//
//        hashtable = new LinkedList[sizeOfnewTable];
//
//        for (int i = 0; i < hashtable.length; i++)
//            hashtable[i] = null;
//
//        for (int i = 0; i < new_hastable.length; i++) {
//            if (old_hastable[i] != null){
//            }
//        }
//
//
//        for (LinkedList<HTObject> objects: old_hastable) {
//            if (objects != null){
//                insertHash(objects.get(0).getKey(), objects.get(0).getValue());
//                if (objects.get(0).getKey().equals(objects.get(0).key) && objects.get(0) != null && objects.size() > 1)
//                    for (int i = 0; i < objects.size(); i++)
//                        insertHash(objects.get(i).getKey(), objects.get(i).getValue());
//            }
//        }
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




