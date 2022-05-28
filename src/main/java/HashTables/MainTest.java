package HashTables;

import BinaryTree.BinarySearchTree;
import BinaryTree.SplayTree;

class MainTest{
public static void main(String[]args){

    LinearHash linearHash = new LinearHash(2000, 0.75);

    linearHash.insert("hello", 25);
    linearHash.insert("hello", 25);


    linearHash.searchByKey("hello");

    linearHash.deleteByKey("hello");
    System.out.println(linearHash.searchByKey("hello"));
    linearHash.deleteByKey("hello");

    System.out.println(linearHash.searchByKey("hello"));
    System.out.println(linearHash.searchByKey("hello"));

    }
}