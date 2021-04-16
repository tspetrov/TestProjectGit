package OCP.Chapter4;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.*;

public class TestFunctionalInterfaces {
    // Things to try out :

    //Supplier<T>
    //Consumer<T>, BiConsumer<T, U>
    //Predicate<T>, BiPredicate<T,U>
    //Function<T,R>, BiFunction<T,U,R>
    //UnaryOperator<T>, BinaryOperator<T>

    public static <T> void myFunctionSupplier(Supplier<T> supplier) {
        System.out.println(supplier.get());
    }

    public static <T> void myFunctionConsumer(Consumer<T> consumer, T a) {
         consumer.accept(a);
    }

    public static <T> boolean myFunctionPredicate(Predicate<T> predicate, T a) {
        return predicate.test(a);
    }

    public static <T, R> R myFunction(Function<T,R> function, T a) {
        return function.apply(a);
    }

    public static <T,U,R> R myBiFunction(BiFunction<T,U,R> function, T a, U b) {
        return function.apply(a,b);
    }

    public static void main(String[] args) {

        //Supplier Test
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Supplier Test");
        Supplier<LocalDateTime> mySupplier = LocalDateTime::now;
        myFunctionSupplier(LocalDateTime::now);
        System.out.println(mySupplier.get());

        //Consumer Test
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Consumer Test");
        myFunctionConsumer(System.out::println, "ceco");
        HashMap<String, Integer> myMap = new HashMap<>();
        BiConsumer<String, Integer> binConsumer =  myMap::put;
        binConsumer.accept("Ceco", 1);
        binConsumer.accept("Cecoto", 2);
        myMap.forEach((k,v) -> System.out.println(k + " = " + v));

        //Predicate Test
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Predicate Test");
        System.out.println( myFunctionPredicate(x -> x>5, 6));


        //Predicate Test
        System.out.println("---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Function Test");
        System.out.println(myFunction((Integer x) -> x*3, 5));
        System.out.println(myBiFunction((Integer x, Integer y) -> x*y, 5,4));





    }
}
