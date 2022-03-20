package HashTables;

import BinaryTree.BinarySearchTree;
import BinaryTree.SplayTree;

class MainTest{
public static void main(String[]args){

    SplayTree splayTree = new SplayTree();
    BinarySearchTree binarySearchTree = new BinarySearchTree();


    LinearHash linearHash = new LinearHash(100, 90);
    linearHash.insert("oo", 78);



    }
}