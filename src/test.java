public class test {

    public static void main(String[] args){
        HashTable test = new HashTable(6);
        test.insert("a");
        test.insert("b");
        test.insert("c");
        test.insert("d");



        System.out.println(test.toString());

        System.out.println(test.getStatsLog());

    }
}
