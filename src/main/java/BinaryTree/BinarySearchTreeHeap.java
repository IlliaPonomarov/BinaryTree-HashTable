package BinaryTree;

public class BinarySearchTreeHeap {
    int CAPACITY = 1000;
    static int count_of_elements = 0;
    int[] heapArray = new int[CAPACITY];

    public BinarySearchTreeHeap() {
        for (int i = 0; i < heapArray.length; i++)
            heapArray[i] = -1;
    }

    private int getRightNode(int index){
        return (index * 2) + 2;
    }

    private int getLeftNode(int index){
        return (index * 2) + 1;
    }

    private int getRootNode(int index){
        return (index - 1) / 2;
    }

    public void insert(int value){

        int index = 0;

        if (count_of_elements == CAPACITY) {
            System.out.println("Heap is full.");
            return;
        }
        else{

            heapArray[ count_of_elements++] = value;
            heapTop(count_of_elements - 1);

        }
    }

    public int search(int key){

        for (int i = 0; i < heapArray.length; i++)
            if (heapArray[i] == key)
                return i;

        return -1;
    }



    void heapTop(int index){

        int temp = heapArray[index];
        while (index > 0 && temp > heapArray[getRootNode(index)]){
            heapArray[index] = heapArray[getRootNode(index)];
            index = getRootNode(index);
        }

        heapArray[index] = temp;
    }

    void heapDown(int index){

    }

    public int delete(int key){
        int tmp = 0, child;

        heapArray[key] = heapArray[count_of_elements - 1];
        count_of_elements--;

        tmp = heapArray[key];

        while ((getLeftNode(key)) < count_of_elements){
            child = max(key);
            if (tmp < heapArray[child]){
                heapArray[key] = heapArray[child];
            }else
                break;
            key = child;
        }

        heapArray[key] = tmp;


        return key;
    }

    public int max(int index){
        return heapArray[getLeftNode(index)] > heapArray[getRightNode(index)] ? getLeftNode(index) : getRightNode(index);
    }


    public void print(){
        for (int i = 0; i < CAPACITY; i++)
            if (heapArray[i] != -1)
                System.out.print(heapArray[i] + " ");

        System.out.println();
    }


}
