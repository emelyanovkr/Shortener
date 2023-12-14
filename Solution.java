package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args)
    {

    }

    public static Set<Long> getIds(Shortener shortener, Set<String> strings)
    {
        Set<Long> ids = new HashSet<>();
        for(String str : strings)
        {
            ids.add(shortener.getId(str));
        }

        return ids;
    }

    public static Set<String> getStrings(Shortener shortener, Set<Long> keys)
    {
        Set<String> str = new HashSet<>();
        for(Long id : keys)
        {
            str.add(shortener.getString(id));
        }

        return str;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber)
    {
        Helper.printMessage(strategy.getClass().getSimpleName() + ":");
        Set<String> data = new HashSet<>();
        for(int i = 0; i < elementsNumber; ++i)
        {
            data.add(Helper.generateRandomString());
        }
        Shortener shortener = new Shortener(strategy);

        Date startTime = new Date();
        Set<Long> ids = getIds(shortener, data);
        Date stopTime = new Date();

        Helper.printMessage(Long.toString((stopTime.getTime() - startTime.getTime())));

        Date startStrTime = new Date();
        Set<String> strings = getStrings(shortener, ids);
        Date stopStrTime = new Date();

        Helper.printMessage(Long.toString((stopStrTime.getTime() - startStrTime.getTime())));

        if(data.equals(strings))
        {
            Helper.printMessage("Тест пройден.");
        }
        else
        {
            Helper.printMessage("Тест не пройден.");
        }
    }

}
