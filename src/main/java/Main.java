import BinaryTree.AvlTree;
import BinaryTree.BinarySearchTree;
import BinaryTree.DAO.TreeDAO;
import BinaryTree.DAO.User;
import HashTables.ChainHash;
import HashTables.LinkedListIm;

import java.util.Map;

public class Main {

    protected static Map<Integer, User> users;
    protected static BinarySearchTree binarySearchTree = new BinarySearchTree();
    protected static AvlTree avlTree = new AvlTree();
    protected static ChainHash chainHash = new ChainHash();


    public static void main(String[] args) {

        LinkedListIm list = new LinkedListIm();
        list.insertLinkedList(list, 1);
        list.insertLinkedList(list, 12);
        list.insertLinkedList(list, 3);

        list.print();


//
//        System.out.println("Binary Search Tree: ");
//        System.out.println("BST Insert:");
//        System.out.println(getTestOfInsertForBST());
//
//
//        System.out.println("BST Search by Key:");
//        System.out.println(searchByKeyTestBST());
//
//        System.out.println("BST Delete:");
//        System.out.println(getTestIDeleteForBST());
//        System.out.println();
//
//        ////
//
//        System.out.println("AVL Tree: ");
//
//        System.out.println("AVL Insert: ");
//        System.out.println(getTestOfInsertForAVL());
//
//        System.out.println("AVL Search by Key: ");
//        System.out.println(searchByKeyAVL());
//
//        System.out.println("AVL Delete: ");
//        System.out.println(getTestOfDeleteForAVL());

        System.out.println(getTimeTestForInsert());

    }

    //***************************
    //
    //  BINARY SEARCH TREE TEST
    //
    //***************************

    //Insert Test
    public static BinarySearchTree insertBST() {

        users = TreeDAO.getData();

        for (Map.Entry<Integer, User> userss : users.entrySet())
            binarySearchTree.insert(userss.getKey());

        return binarySearchTree;
    }

    public static double getTestOfInsertForBST() {


        for (int i = 0; i < 20; i++)
            insertBST();

        int count = 1000;

        while (true) {
            long begin = System.nanoTime();

            for (int i = 0; i < count; i++)
                insertBST();

            long end = System.nanoTime();

            if ((end - begin) < 1000000000) {
                count *= 1000;
                continue;
            }
            return (double) (end - begin) / count;
        }

    }

    //Delete Test
    public static void deleteBST() {

        BinarySearchTree bst = new BinarySearchTree();

        Map<Integer, User> user = TreeDAO.getData();

        for (Map.Entry<Integer, User> users : user.entrySet())
            bst.deleteKey(users.getKey());

    }

    public static double getTestIDeleteForBST() {
        for (int i = 0; i < 20; i++)
            deleteBST();

        int count = 1000;

        while (true) {
            long begin = System.nanoTime();

            for (int i = 0; i < count; i++)
                deleteBST();

            long end = System.nanoTime();

            if ((end - begin) < 1000000000) {
                count *= 1000;
                continue;
            }
            return (double) (end - begin) / count;
        }

    }

    //Search Test
    public static double searchByKeyTestBST() {

        for (int i = 0; i < 20; i++)
            binarySearchTree.searchByKey((int) Math.random() * 1000);

        int count = 1000;

        while (true) {
            long begin = System.nanoTime();

            for (int i = 0; i < count; i++)
                binarySearchTree.searchByKey((int) Math.random() * 1000);

            long end = System.nanoTime();

            if ((end - begin) < 1000000000) {
                count *= 1000;
                continue;
            }
            return (double) (end - begin) / count;
        }
    }

    //***************************
    //
    //     AVL TREE TEST
    //
    //***************************

    //Insert
    public static AvlTree insertAVL() {

        users = TreeDAO.getData();

        for (Map.Entry<Integer, User> userss : users.entrySet())
            avlTree.insert(userss.getKey());

        return avlTree;
    }

    public static double getTestOfInsertForAVL() {


        for (int i = 0; i < 20; i++)
            insertAVL();

        int count = 1000;

        while (true) {
            long begin = System.nanoTime();

            for (int i = 0; i < count; i++)
                insertAVL();

            long end = System.nanoTime();

            if ((end - begin) < 1000000000) {
                count *= 1000;
                continue;
            }
            return (double) (end - begin) / count;
        }

    }

    //Search
    public static double searchByKeyAVL(){
        for (int i = 0; i < 20; i++)
            avlTree.searchByKey((int) Math.random() * 1000);

        int count = 1000;

        while (true) {
            long begin = System.nanoTime();

            for (int i = 0; i < count; i++)
                avlTree.searchByKey((int) Math.random() * 1000);

            long end = System.nanoTime();

            if ((end - begin) < 1000000000) {
                count *= 1000;
                continue;
            }
            return (double) (end - begin) / count;
        }
    }

    //Delete
    public static AvlTree deleteAVL() {

        users = TreeDAO.getData();

        for (Map.Entry<Integer, User> userss : users.entrySet())
            avlTree.deleteNode(userss.getKey());

        return avlTree;
    }

    public static double getTestOfDeleteForAVL() {

        for (int i = 0; i < 20; i++)
            deleteAVL();

        int count = 1000;

        while (true) {
            long begin = System.nanoTime();

            for (int i = 0; i < count; i++)
                deleteAVL();

            long end = System.nanoTime();

            if ((end - begin) < 1000000000) {
                count *= 1000;
                continue;
            }
            return (double) (end - begin) / count;
        }

    }



    //**************************************
    //
    //             Chain Hash
    //
    //**************************************


    public static ChainHash insertChainHashTest(){

        users = TreeDAO.getData();
        for (Map.Entry<Integer, User> userss : users.entrySet())
            chainHash.insertHash(userss.getKey(), userss.getValue().toString());

        return chainHash;

    }

    public static Double getTimeTestForInsert(){
        for (int i = 0; i < 20; i++)
            insertChainHashTest();

        int count = 1000;

        while (true) {
            long begin = System.nanoTime();

            for (int i = 0; i < count; i++)
                insertChainHashTest();

            long end = System.nanoTime();

            if ((end - begin) < 1000000000) {
                count *= 1000;
                continue;
            }
            return (double) (end - begin) / count;
        }
    }


}
