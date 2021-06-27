package Homework6;

import java.io.Serializable;

public class Singleton implements Serializable {

    private static final long serialVersionUID = 1868339877828653081L;
    public static Singleton instance = new Singleton();

    private Singleton() {
    }

    protected Object readResolve() {
        return instance;
    }
}

