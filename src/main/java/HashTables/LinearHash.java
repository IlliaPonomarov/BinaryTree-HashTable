package HashTables;

import java.util.Arrays;

public class LinearHash {
    int capacity = 1000;
    int size;
    double loadfactor;

    HTObject[] hashtable;


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

    public LinearHash(int capacity, double loadfactor) {

        this.capacity = capacity;
        this.loadfactor = loadfactor;
        this.hashtable = new HTObject[capacity + 1];

        for (int i = 0; i < size + 1; i++)
            this.hashtable[i] = null;
    }

    public int hashFunction(String key) {
        return (key.hashCode() & 0x7FFFFFFF) % capacity;
    }

    public void insert(String key, Integer value) {
        int index = hashFunction(key);
        HTObject htObj = hashtable[index];


        if (htObj == null) {
            htObj = new HTObject(key, value);
            hashtable[index] = htObj;
        } else if (htObj != null) {

            for (int i = index; i < hashtable.length; i++) {

                if (hashtable[i] == null) {
                    htObj = new HTObject(key, value);
                    hashtable[index] = htObj;
                    return;
                }
            }
        }



        size++;

        double loadfactor = (1.0 * size) / capacity;

        if (loadfactor > this.loadfactor) {
            resize();
        }


        return;
    }




    public HTObject searchByKey(String key) {

        int index = hashFunction(key);

        for (int i = index; i < hashtable.length; i++) {
            if (hashtable[i] != null) {
                if (hashtable[i].getKey().equals(key)) {
                    HTObject h = hashtable[i];
                  return h;
                }
            }
        }
      return null;
    }

    public void deleteByKey(String key) {
        int index = hashFunction(key);

        for (int i = index; i < hashtable.length; i++)
            if (hashtable[i] != null)
                if (hashtable[i].getKey().equals(key))
                    hashtable[i] = null;
        return;
    }

    public void resize() {


        HTObject[] newtable = new HTObject[hashtable.length * 2];
        for (int i = 0; i < hashtable.length; i++) {

            HTObject list = hashtable[i];
            newtable[i] = list;
            }


        hashtable = newtable;

        if (hashtable.length > 10000000){
            this.capacity = 1000000;
            resize();
        }

}


    public void getAll() {
       Arrays.stream(hashtable).filter(object -> object != null).forEach(i -> System.out.println(i.getKey() + " " + i.getValue()));
    }
}



























