package HashTables;

class MainTest{
public static void main(String[]args){

        LinearHash linearHash = new LinearHash();

        linearHash.insert("hot", 66);
        linearHash.insert("hot", 77);
        linearHash.insert("hot", 767);
        linearHash.insert("hot", 67);
        linearHash.insert("hot", 770);
        linearHash.insert("idle", 90);
        linearHash.insert("stove", 98);
        linearHash.insert("horse", 1);

        linearHash.searchByKey("stove");

    }
}