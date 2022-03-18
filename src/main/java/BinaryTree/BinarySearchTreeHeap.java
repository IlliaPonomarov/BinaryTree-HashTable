package BinaryTree;

import java.util.*;

public class BinarySearchTreeHeap {
    int CAPACITY = 1000;
    static int count_of_elements = 0;
    String[] heapArray = new String[CAPACITY];

    private int getRightNode(int index){
        return index * 2 + 2;
    }

    private int getLeftNode(int index){
        return index * 2 + 1;
    }

    private int getRootNode(int index){
        return (index - 1) / 2;
    }

    public void insert(String key){

        int i = 0;

        if (count_of_elements == CAPACITY)
            return;
        else{
            i = count_of_elements;
            heapArray[i] = key;
            count_of_elements++;
        }



    }

}
