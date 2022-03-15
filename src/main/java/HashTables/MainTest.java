package HashTables;

import java.util.LinkedList;
import java.util.Objects;
import java.util.TreeSet;

public class MainTest {
    public static void main(String[] args) {


        Integer key = 16;
       ChainHash chainHash = new ChainHash();

       chainHash.insertHash(12, "coffee");
       chainHash.insertHash(11, "command");
       chainHash.insertHash(33, "sometime");
       chainHash.insertHash(21, "forest");
       chainHash.insertHash(89, "plant");

    }


}
