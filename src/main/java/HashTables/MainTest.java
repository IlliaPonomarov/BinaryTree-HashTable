package HashTables;

import BinaryTree.BinarySearchTreeHeap;

class MainTest{
public static void main(String[]args){

        LinearHash linearHash = new LinearHash();

        BinarySearchTreeHeap binarySearchTreeHeap = new BinarySearchTreeHeap();
        binarySearchTreeHeap.insert(1);
        binarySearchTreeHeap.insert(3);
        binarySearchTreeHeap.insert(6);
        binarySearchTreeHeap.insert(9);
        binarySearchTreeHeap.insert(5);
        binarySearchTreeHeap.insert(8);

        System.out.println(binarySearchTreeHeap.search(8));

        binarySearchTreeHeap.print();
        binarySearchTreeHeap.delete(8);
        binarySearchTreeHeap.print();


    }
}