package com.spring.mvc.factory;

import java.lang.reflect.InvocationTargetException;

public class StaticFactory {

    private StaticFactory(){}

    @SuppressWarnings("unchecked")
    public static <T> T newInstance(String className){
        T instance = null;
        try {
            instance = (T) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                | NoSuchMethodException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return instance;
    }

    @SuppressWarnings("unchecked")
    public static <T> T newInstance(Class<?> clazz){
        T instance = null;
        try {
            instance = (T) clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException
                | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return instance;
    }

}
