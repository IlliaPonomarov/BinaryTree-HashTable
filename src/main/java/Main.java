import BinaryTree.AvlTree;
import BinaryTree.BinarySearchTree;
import DAO.HashDao;
import DAO.TreeDAO;
import DAO.User;
import HashTables.ChainHash;
import HashTables.LinearHash;

import java.util.Date;
import java.util.Map;

public class Main {

    protected static Map<Integer, User> users;

    
    protected static BinarySearchTree binarySearchTree = new BinarySearchTree();
    protected static AvlTree avlTree = new AvlTree();
    protected static ChainHash chainHash = new ChainHash(1000, 0.75);
    protected static LinearHash linearHash = new LinearHash(2001, 0.75);


    public static void main(String[] args) throws InterruptedException {


        hashTablesTest();
       // chainHash.getAll();

    }


    public static void treeTest(){

        System.out.println("Binary Search Tree: ");
        System.out.println("BST Insert: " + getTestOfInsertForBST());
        System.out.println("BST Search by Key: " + searchByKeyTestBST());
        System.out.println("BST Delete: " + getTestIDeleteForBST());

        System.out.println();
        System.out.println();

        System.out.println("Binary Heap Tree: " );
        System.out.println("Insert: ");
        System.out.println("Search: ");

        System.out.println();
        System.out.println();


        System.out.println();
        System.out.println();

    }

    public static void hashTablesTest() throws InterruptedException {
        Date date = new Date();
        System.out.println();

        // 1000
        long sart1 = System.currentTimeMillis();
        System.out.println("Chain Hash Test (1000 elements):");
        System.out.println("Insert: " + getTimeInsertChainHash(1000) + "   " + (System.currentTimeMillis() - sart1)  + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Search by key: " + getTimeSearchByKeyChainHash(1000) + "   " + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Delete by key: " + getTimeDeleteByKeyChainHash(1000) + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        System.out.println();
        Thread.sleep(2000);
        System.out.println("Linear Hash Test: (1000 elements) ");

        sart1 = System.currentTimeMillis();
        System.out.println("Insert: " + getTimeInsertLinearHash(1000)  + "  " + (System.currentTimeMillis() - sart1) +  "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Search by key: " + getTimeSearchByKeyLinearHash(1000)  + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Delete by key: " + getTimeDeleteByKeyLinearHash(1000)  +  "  " + (System.currentTimeMillis() - sart1) + "m/s");




        // 1 000 000
        sart1 = System.currentTimeMillis();
        System.out.println("Chain Hash Test (1 000 000 elements):");
        System.out.println("Insert: " + getTimeInsertChainHash(1000000)  + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Search by key: " + getTimeSearchByKeyChainHash(1000000)  + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Delete by key: " + getTimeDeleteByKeyChainHash(1000000)  + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        System.out.println();
        Thread.sleep(2000);
        System.out.println("Linear Hash Test: (1 000 000 elements) ");

        sart1 = System.currentTimeMillis();
        System.out.println("Insert: " + getTimeInsertLinearHash(1000000)   + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Search by key: " + getTimeSearchByKeyLinearHash(1000000)  + "  "   + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Delete by key: " + getTimeDeleteByKeyLinearHash(1000000)  + "  "  + "  " + (System.currentTimeMillis() - sart1) + "m/s");


        // 10 000 000

        sart1 = System.currentTimeMillis();
        System.out.println("Chain Hash Test (10 000 000 elements):");
        System.out.println("Insert: " + getTimeInsertChainHash(10000000)  + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Search by key: " + getTimeSearchByKeyChainHash(10000000)  + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Delete by key: " + getTimeDeleteByKeyChainHash(10000000)  + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        System.out.println();
        Thread.sleep(2000);
        System.out.println("Linear Hash Test: (10 000 000 elements) ");

        sart1 = System.currentTimeMillis();
        System.out.println("Insert: " + getTimeInsertLinearHash(1000000)   + "  " + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Search by key: " + getTimeSearchByKeyLinearHash(1000000)  + "  "   + (System.currentTimeMillis() - sart1) + "m/s");

        sart1 = System.currentTimeMillis();
        System.out.println("Delete by key: " + getTimeDeleteByKeyLinearHash(1000000)  + "  "  + "  " + (System.currentTimeMillis() - sart1) + "m/s");

    }

    //***************************
    //
    //  BINARY SEARCH TREE TEST , FIRST IMPLEMENTATION
    //
    //***************************


    //***************************
    //
    //  BINARY SEARCH TREE TEST, SECOND IMPLEMENTATION
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
            bst.deleteByKey(users.getKey());

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


    //**************************************
    //
    //             Linear Hash
    //
    //**************************************


    //insert chainhash
    public static LinearHash insertLinearHashTest(){

        String[] test = HashDao.getDataHash();


        for (int i = 0; i < test.length; i++)
            linearHash.insert(test[(int) Math.floor(Math.random() * 400)], (int) Math.floor(Math.random() * 500));

        return linearHash;

    }

    public static String getTimeInsertChainHash(int count){

        for (int i = 0; i < 20; i++)
            insertChainHashTest();


        for (int i = 0; i < count; i++) {
            insertChainHashTest();
        }



        return "";
    }


    //search
    public static LinearHash searchByKeyTestLinearHash(){

        String[] test = HashDao.getDataHash();


        for (int i = 0; i < test.length; i++)
            linearHash.searchByKey(test[(int) Math.random() * 500]);

        return linearHash;

    }

    public static Double getTimeSearchByKeyLinearHash(int count){
        for (int i = 0; i < 20; i++)
            searchByKeyTestLinearHash();


        long beg = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            searchByKeyTestLinearHash();
        }
        long en = System.currentTimeMillis();

        return (double) en - beg / count;
    }

    //delete

    public static LinearHash deleteByKeyTestLinearHash(){

        String[] test = HashDao.getDataHash();


        for (int i = 0; i < test.length; i++)
            linearHash.deleteByKey(test[(int) Math.random() * 500]);

        return linearHash;

    }

    public static Double getTimeDeleteByKeyLinearHash(int count){
        for (int i = 0; i < 20; i++)
           deleteByKeyTestLinearHash();


        for (int i = 0; i < 20; i++)
            deleteByKeyTestLinearHash();


        long beg = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            deleteByKeyTestLinearHash();
        }
        long en = System.currentTimeMillis();

        return (double) en - beg / count;
    }

    //resize
//    public static Double resizeLinearHash(){
//        for (int i = 0; i < 20; i++)
//           linearHash.resize();
//
//        int count = 1000;
//
//        while (true) {
//            long begin = System.nanoTime();
//
//            for (int i = 0; i < count; i++)
//                linearHash.resize();
//
//            long end = System.nanoTime();
//
//            if ((end - begin) < 1000000000) {
//                count *= 1000;
//                continue;
//            }
//            return (double) (end - begin) / count;
//        }
//    }


    //***********************************
    //
    //          Chain Hash
    //
    //***********************************

    //insert linearHash
    public static ChainHash insertChainHashTest(){

        String[] test = HashDao.getDataHash();


        for (int i = 0; i < test.length; i++)
            chainHash.insertHash(test[(int) Math.random() * 500], (int) Math.random() * 1000);

        return chainHash;

    }

    public static String getTimeInsertLinearHash(int count){

        for (int i = 0; i < 20; i++)
            insertLinearHashTest();


        for (int i = 0; i < count; i++) {
            insertLinearHashTest();
        }


        return " ";
    }

    //search
    public static ChainHash searchByKeyTestChainHash(){

        String[] test = HashDao.getDataHash();


        for (int i = 0; i < test.length; i++)
            chainHash.getValueByKey(test[(int) Math.random() * 500]);

        return chainHash;

    }

    public static String getTimeSearchByKeyChainHash(int count){
        for (int i = 0; i < 20; i++)
            searchByKeyTestChainHash();



            for (int i = 0; i < count; i++)
                searchByKeyTestChainHash();

           return "";
    }

    //delete
    public static ChainHash deleteByKeyTestChainHash(){

        String[] test = HashDao.getDataHash();


        for (int i = 0; i < test.length; i++)
            chainHash.deleteByKey(test[(int) Math.random() * 500]);

        return chainHash;

    }

    public static String getTimeDeleteByKeyChainHash(int count){
        for (int i = 0; i < 20; i++)
            deleteByKeyTestChainHash();



            for (int i = 0; i < count; i++)
                deleteByKeyTestChainHash();

          return "";
    }

    //resize
//    public static Double resizeChainHash(){
//        for (int i = 0; i < 20; i++)
//            chainHash.resize();
//
//        int count = 1000;
//
//        while (true) {
//            long begin = System.nanoTime();
//
//            for (int i = 0; i < count; i++)
//                chainHash.resize();
//
//            long end = System.nanoTime();
//
//            if ((end - begin) < 1000000000) {
//                count *= 1000;
//                continue;
//            }
//            return (double) (end - begin) / count;
//        }
//    }

}
