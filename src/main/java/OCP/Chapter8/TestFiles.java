package OCP.Chapter8;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class TestFiles {
    public static void main(String[] args) throws IOException {
//        Reader reader = System.console().reader();
//        System.out.println("Read it = " + reader.read());





        TestFiles testFiles = new TestFiles();
        testFiles.test(System.out::println, 5);

        Map<Integer, String> ceco = new HashMap<>();
        ceco.put(1, "whatever");


        testFiles.test((Map<Integer,String> x) -> x.forEach((y,z) -> System.out.println("y =" + y + ", z = " +z)), ceco);
    }


    public <T> void test(Consumer<T> consumer, T value) {
        consumer.accept(value);
    }
}
