package com.nc.rnd.enums;

import sun.rmi.runtime.Log;

import java.util.*;

/**
 * Created by nirk0816 on 2/8/2017.
 */
public class EnumTest {

    public static void main(String[] args) {

        LoggerEnum loggerEnum = LoggerEnum.DEBUG;
        System.out.println(loggerEnum);

        LoggerEnhancedEnum loggerEnhancedEnum = LoggerEnhancedEnum.ERROR;
        System.out.println(loggerEnhancedEnum);
        System.out.println(loggerEnhancedEnum.getValue());

        switch (loggerEnhancedEnum)
        {
            case DEBUG:
                System.out.println("Logging level is " + loggerEnhancedEnum.getValue() + " it means DEBUG");
                break;
            case INFO:
                System.out.println("Logging level is " + loggerEnhancedEnum.getValue() + " it means INFO");
                break;
            case ERROR:
                System.out.println("Logging level is " + loggerEnhancedEnum.getValue() + " it means ERROR");
                break;
        }

        final int ordinal = loggerEnhancedEnum.ordinal();
        System.out.println("Ordinal is " + ordinal);

        loggerEnhancedEnum = LoggerEnhancedEnum.DEBUG;
        System.out.println("New Ordinal is " + loggerEnhancedEnum.ordinal());


        if(loggerEnhancedEnum == LoggerEnhancedEnum.DEBUG)
        {
            System.out.println("I could compare enum variables using == operator");
        }


        System.out.println("Here are all the values of loggerEnhancedEnum using loggerEnhancedEnum.values() method provided by enum \n" + Arrays.toString(LoggerEnhancedEnum.values()) );

        System.out.println("toString() on regular ENUM class : " + loggerEnum.toString());

        System.out.println("toString() on enum can be overriden : " + loggerEnhancedEnum.toString());

        Set<LoggerEnhancedEnum> loggerEnhancedEnumEnumSet = EnumSet.allOf(LoggerEnhancedEnum.class);

        Map<LoggerEnhancedEnum, String> loggerEnhancedEnumEnumMap = new EnumMap(LoggerEnhancedEnum.class);
        loggerEnhancedEnumEnumMap.put(LoggerEnhancedEnum.DEBUG,"debug");
        loggerEnhancedEnumEnumMap.put(LoggerEnhancedEnum.ERROR,"error");
        loggerEnhancedEnumEnumMap.put(LoggerEnhancedEnum.INFO,"info");

        System.out.println("Iterating using ENUMSET");
        Iterator<LoggerEnhancedEnum> itr = loggerEnhancedEnumEnumSet.iterator();
        while (itr.hasNext())
        {
            System.out.println(itr.next());
        }

        System.out.println("Iterating using ENUMMAP");
        Set<LoggerEnhancedEnum> keySet = loggerEnhancedEnumEnumMap.keySet();

        Iterator<LoggerEnhancedEnum> itr1 = keySet.iterator();
        while (itr1.hasNext())
        {
            LoggerEnhancedEnum loggerEnhancedEnumKey = itr1.next();
            System.out.println(loggerEnhancedEnumKey.getValue());
            System.out.println(loggerEnhancedEnumEnumMap.get(loggerEnhancedEnumKey));
        }

        System.out.println("ENUM can implement Run method");
        Thread t = new Thread(LoggerEnhancedRunnableEnum.DEBUG);
        t.start();


    }
}
