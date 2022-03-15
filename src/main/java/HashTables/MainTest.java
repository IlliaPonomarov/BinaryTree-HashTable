package HashTables;

public class MainTest {
    public static void main(String[] args) {
        ChainHash chainHash = new ChainHash();
        chainHash.insertHash(121, chainHash);
        chainHash.insertHash(12, chainHash);
        chainHash.insertHash(12, chainHash);
        chainHash.insertHash(12, chainHash);
        chainHash.insertHash(11, chainHash);
        chainHash.insertHash(1, chainHash);
        chainHash.insertHash(32, chainHash);

        chainHash.printHash();
    }
}
