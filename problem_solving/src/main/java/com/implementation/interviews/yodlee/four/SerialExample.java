package com.implementation.interviews.yodlee.four;

import java.io.*;

public class SerialExample {
    public static void printdata(Emp object1) {
        System.out.println("name = "+ object1.name);
        System.out.println("age = "+ object1.age);
        System.out.println("a = "+ object1.a);
        System.out.println("b = "+ object1.b);
    }

    public static void main(String[] args) {
        Emp object = new Emp("ab", 20, 2, 1000);
        String filename = "sarath.txt";

        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(object);
            out.close();
            file.close();
            System.out.println("Object has been serialized \n" + "Data before serialization.");
            printdata(object);
            object.b = 2000;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        object = null;
        // Deserialization
        try {
            //Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            object = (Emp)in.readObject();
            in.close();
            file.close();
            System.out.println("object has been deserialized \n" + "Data after serialization.");
            printdata(object);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
