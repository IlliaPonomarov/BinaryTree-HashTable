package HashTables;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.TreeSet;

public class MainTest {
    public static void main(String[] args) {


        Integer key = 16;
       ChainHash chainHash = new ChainHash();

       chainHash.insertHash(32, "coffee");
       chainHash.insertHash(11, "command");
       chainHash.insertHash(11, "hello");
       chainHash.insertHash(11, "threat");
       chainHash.insertHash(11, "commandos");
       chainHash.insertHash(33, "sometime");
       chainHash.insertHash(21, "forest");
       chainHash.insertHash(89, "plant");

        chainHash.getAll();

    }


}
