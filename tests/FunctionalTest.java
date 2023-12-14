package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class FunctionalTest {

    public void testStorage(Shortener shortener)
    {
        String one = Helper.generateRandomString();
        String two = Helper.generateRandomString();
        String three = one;

        Long id_one = shortener.getId(one);
        Long id_two = shortener.getId(two);
        Long id_three = shortener.getId(three);

        assertNotEquals(one, two);
        assertNotEquals(two, three);

        assertEquals(one, three);

        String str_one = shortener.getString(id_one);
        String str_two = shortener.getString(id_two);
        String str_three = shortener.getString(id_three);

        assertEquals(str_one, one);
        assertEquals(str_two, two);
        assertEquals(str_three, three);
    }

    @Test
    public void testHashMapStorageStrategy()
    {
        HashMapStorageStrategy strategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy()
    {
        OurHashMapStorageStrategy strategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testFileStorageStrategy()
    {
        FileStorageStrategy strategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testHashBiMapStorageStrategy()
    {
        HashBiMapStorageStrategy strategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testDualHashBidiMapStorageStrategy()
    {
        DualHashBidiMapStorageStrategy strategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashBiMapStorageStrategy()
    {
        OurHashBiMapStorageStrategy strategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(strategy);
        testStorage(shortener);
    }
}
