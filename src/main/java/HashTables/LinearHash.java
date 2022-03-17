package HashTables;

import java.util.Arrays;

public class LinearHash {

    final static Integer CAPACITY = 1000;

    HTObject[] hashtable = new HTObject[CAPACITY + 1];

    class HTObject {
        private String key;
        private Integer value;

        public HTObject(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }

    public LinearHash() {

        for (int i = 0; i < CAPACITY + 1 ; i++)
           this.hashtable[i] = null;
    }

    public int hashFunction(String key) {
        return (key.hashCode() & 0x7FFFFFFF) % CAPACITY;
    }

    public void insert(String key, Integer value) {
        int index = hashFunction(key);
        HTObject htObj = hashtable[index];

        if (htObj == null) {
            htObj = new HTObject(key, value);
            hashtable[index] = htObj;
        } else if (htObj != null) {

            for (int i = 1; i <= hashtable.length; i++) {
                index = index + 1;
                if (hashtable[index] == null) {
                    htObj = new HTObject(key, value);
                    hashtable[index] = htObj;
                    return;
                }
            }
        }
    }

    public void searchByKey(String key){

        int index = hashFunction(key);
        HTObject htObject = hashtable[index];

            for (int i = index; i < hashtable.length; i++) {
                if (hashtable[i] != null) {
                    if (hashtable[i].getKey().equals(key)) {
                        HTObject h = hashtable[i];
                        System.out.println(h.getKey() + " " + h.getValue());
                    }
                }
            }
        return;
    }
    public void getAll() {
       Arrays.stream(hashtable).filter(object -> object != null).forEach(i -> System.out.println(i.getKey() + " " + i.getValue()));
    }
}



























