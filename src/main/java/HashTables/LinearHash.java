package HashTables;

import java.util.Arrays;

public class LinearHash {

    final static Integer CAPACITY = 1000;

    HTObject[] hashtable = new HTObject[CAPACITY + 1];

    HTObject i = new HTObject("lol", 9);
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

        i.getKey();
        for (int i = 0; i < CAPACITY + 1 ; i++)
           this.hashtable[i] = null;
    }

    public int hashFunction(String key) {
        return (key.hashCode() & 0x7FFFFFFF) % CAPACITY;
    }

    public HTObject insert(String key, Integer value) {
        int index = hashFunction(key);
        HTObject htObj = hashtable[index];

        if (htObj == null) {
            htObj = new HTObject(key, value);
            hashtable[index] = htObj;
        } else if (htObj != null) {

            for (int i = 0; i < hashtable.length; i++) {
                index = index + 1;
                if (hashtable[index] == null) {
                    htObj = new HTObject(key, value);
                    hashtable[index] = htObj;
                    return hashtable[index];
                }
            }
        }

        return hashtable[index];
    }

    public void searchByKey(String key){

        int index = hashFunction(key);

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

    public void deleteByKey(String key){
        int index = hashFunction(key);

        for (int i = index; i < hashtable.length; i++)
            if (hashtable[i] != null)
                if (hashtable[i].getKey().equals(key))
                    hashtable[i] = null;
        return;
    }

    public void resize(){
        HTObject[] oldHashtable = hashtable;
        HTObject[] newHashtable = new HTObject[hashtable.length * 2];

        for (int i = 0; i < newHashtable.length; i++)
            newHashtable[i] = null;


        for (int i = 0; i < oldHashtable.length; i++) {
            if (oldHashtable[i] != null){
                newHashtable[i] = new HTObject(oldHashtable[i].getKey(), oldHashtable[i].getValue());
            }
        }

        hashtable = newHashtable;

        System.out.println(hashtable.length);

    }


    public void getAll() {
       Arrays.stream(hashtable).filter(object -> object != null).forEach(i -> System.out.println(i.getKey() + " " + i.getValue()));
    }
}



























