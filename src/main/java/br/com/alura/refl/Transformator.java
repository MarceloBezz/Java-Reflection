package br.com.alura.refl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Transformator {
    
    public <I, O> O transform(I input) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        Class<?> source = input.getClass();
        Class<?> target = Class.forName(source.getName() + "DTO");

       O targetClass = (O) target.getDeclaredConstructor().newInstance();

       Field[] sourcesFields = source.getDeclaredFields();
       Field[] targetFields = target.getDeclaredFields();

       return targetClass;
    }
}
