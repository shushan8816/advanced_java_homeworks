package Homework6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        try {
            Singleton instance1 = Singleton.instance;
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file.text"));
            oos.writeObject(instance1);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file.text"));
            Singleton instance2 = (Singleton) ois.readObject();
            ois.close();

            System.out.println("instance1 hashCode:- "
                    + instance1.hashCode());
            System.out.println("instance2 hashCode:- "
                    + instance2.hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
