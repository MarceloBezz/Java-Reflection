package br.com.alura.refl;

public class Transformator {
    
    public <I, O> void transform(I input, Class target) throws ClassNotFoundException {
        Class<?> sourceClass = input.getClass();
        Class<?> targetClass = target;
    }
}
