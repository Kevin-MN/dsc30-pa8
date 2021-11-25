import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {
    HashTable def;
    HashTable norm;

    @Before
    public void setup() {
        def = new HashTable();
        norm = new HashTable(6);
    }

    @Test
    public void default_constructor_test1() {
        HashTable test = new HashTable();

        assertEquals(15, test.capacity());
    }

    @Test
    public void default_constructor_test2() {
        HashTable test = new HashTable();

        assertEquals(0, test.size());
    }

    @Test
    public void default_constructor_test3() {
        HashTable test = new HashTable();

        assertEquals(false, test.lookup("cool"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void normal_constructor_test1() {
        HashTable test = new HashTable(3);
    }

    @Test
    public void normal_constructor_test2() {
        HashTable test = new HashTable(8);

        assertEquals(8, test.capacity());
    }

    @Test
    public void normal_constructor_test3() {
        HashTable test = new HashTable(8);

        assertEquals(0, test.size());
    }

    @Test
    public void normal_constructor_test4() {
        HashTable test = new HashTable(8);
        test.insert("a");
        test.insert("b");
        test.insert("c");
        test.insert("d");
        test.insert("e");

        test.toString();

        assertEquals(16, test.capacity());
        assertEquals(5, test.size());
    }

    @Test(expected = NullPointerException.class)
    public void insert_test1() {
        def.insert(null);
    }

    @Test
    public void insert_test2() {
        assertEquals(0, def.size());
        def.insert("a");
        assertEquals(1, def.size());

    }

    @Test
    public void insert_test3() {
        def.insert("a");
        assertEquals(true, def.lookup("a"));
        assertEquals(false, def.lookup("c"));

    }

    @Test
    public void insert_test4() {
        assertEquals(6, norm.capacity());
        norm.insert("a");
        norm.insert("b");
        norm.insert("c");
        norm.insert("d");
        assertEquals(12, norm.capacity());
    }

    @Test(expected = NullPointerException.class)
    public void delete_test1() {
        assertEquals(false, def.delete(null));
    }

    @Test
    public void delete_test2() {
        assertEquals(false, def.delete("l"));
    }

    @Test
    public void delete_test3() {
        def.insert("a");
        assertEquals(true, def.delete("a"));
    }

    @Test
    public void delete_test4() {
        assertEquals(0, def.size());
        def.insert("a");
        assertEquals(1, def.size());
        def.delete("a");
        assertEquals(false, def.lookup("a"));
    }

    @Test(expected = NullPointerException.class)
    public void lookup_test1() {
        def.lookup(null);
    }

    @Test
    public void lookup_test2() {
        assertEquals(false, def.lookup("b"));
    }

    @Test
    public void lookup_test3() {
        def.insert("a");
        assertEquals(true, def.lookup("a"));
    }

    @Test
    public void lookup_test4() {
        norm.insert("a");
        norm.insert("g");
        norm.insert("m");

        norm.delete("g");

        assertEquals(false, norm.delete("g"));

        assertEquals(true, norm.lookup("m"));
        assertEquals(false, norm.lookup("g"));
    }

    @Test
    public void size_test1() {
        assertEquals(0, def.size());
    }

    @Test
    public void size_test2() {
        def.insert("l");
        assertEquals(1, def.size());
    }

    @Test
    public void size_test3() {
        norm.insert("a");
        norm.insert("b");
        norm.insert("c");
        assertEquals(3, norm.size());
        norm.insert("d");
        assertEquals(4, norm.size());
        assertEquals(true, norm.delete("a"));
        assertEquals(true, norm.delete("b"));
        assertEquals(true, norm.delete("c"));
        assertEquals(true, norm.delete("d"));
        assertEquals(0, norm.size());
    }

    @Test
    public void capacity_test1() {
        assertEquals(15, def.capacity());
    }

    @Test
    public void capacity_test2() {
        assertEquals(6, norm.capacity());
    }

    @Test
    public void capacity_test3() {
        norm.insert("a");
        norm.insert("b");
        norm.insert("c");
        norm.insert("d");
        assertEquals(12, norm.capacity());
    }

    @Test
    public void getStatsLog_test1() {
        assertEquals("", def.getStatsLog());
    }

    @Test
    public void getStatsLog_test2() {
        norm.insert("a");
        norm.insert("b");
        norm.insert("c");
        norm.insert("d");
        assertEquals("Before rehash # 1: load factor 0.67, 0 collision(s).\n", norm.getStatsLog());
    }

    @Test
    public void getStatsLog_test3() {
        norm.insert("a");
        norm.insert("m");
        norm.insert("g");
        norm.insert("l");
        assertEquals(0, norm.getStatsLog().compareTo("Before rehash # 1: load factor 0.67, 3 collision(s).\n"));
    }

}











