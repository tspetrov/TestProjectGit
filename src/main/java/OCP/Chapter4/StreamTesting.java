package OCP.Chapter4;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTesting {
    public static void main(String[] args) {

        // Creating Stream
        Stream<String> empty = Stream.empty();
        Stream<Integer> singleElement = Stream.of(1);
        Stream<Integer> fromArray = Stream.of(1,2,3);

        //Converting between Stream and List
        System.out.println(new ArrayList<String>().stream());
        Stream<Integer> myTestStream = Arrays.asList(1, 2, 3).stream();

        //Parallel Stream
        Stream<Integer> fromListParallel = Arrays.asList(1,2,3).parallelStream();

        //Infinite streams
        Stream.generate(LocalDateTime::now).limit(5).forEach(System.out::println);
        Stream.iterate(1, x->x+3).limit(5).forEach(System.out::println);

        Stream.iterate(new int[] {0,1}, x -> new int[]{x[1], x[0] + x[1]})
                .limit(20)
                .map(x ->x[0])
                .forEach(System.out::println);


        // Stream terminal operations
        System.out.println(myTestStream.allMatch(x -> x>1));
        System.out.println(Arrays.asList(1,2,3).stream().anyMatch(x -> x>1));
        System.out.println(Arrays.asList(1,2,3).stream().noneMatch(x -> x>1));

        Arrays.asList(1,2,3).stream().count();

        Arrays.asList(1,2,3).stream().findAny();
        Arrays.asList(1,2,3).stream().findFirst();
        Arrays.asList(1,2,3).stream().forEach(System.out::print);
        System.out.println(Arrays.asList(1,2,3,7).stream().count());
        Arrays.asList(1,2,3).stream().min(Integer::compare).ifPresent(System.out::println);
        Arrays.asList(1,2,3).stream().max(Integer::compare).ifPresent(System.out::println);
        System.out.println(Arrays.asList(1,2,3,4,5).stream().reduce(1, (x,y) -> x*y));
        Arrays.asList(1,2,3,4,5).stream().reduce( (x,y) -> x*y).ifPresent(System.out::println);


        //collect - special type of reduction - mutable reduction

        Stream<String> stream = Stream.of("w", "o", "l", "f");

        System.out.println(stream.collect(StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append).toString());

        Stream<String> treeSet = Stream.of("w", "o", "l", "f");
        TreeSet<String> set = treeSet.collect(TreeSet::new, TreeSet::add,
                TreeSet::addAll);
        System.out.println(set);

        Collection<Integer> collect = Stream.of(4, 5, 1, 56, 1).collect(Collectors.toCollection(TreeSet<Integer>::new));
        for (Integer integer : collect) {
            System.out.println(integer);
        }

        // Stream intermediate operations

        Stream.of(1,2,3,4).filter(x -> x>=2).forEach(System.out::println);
        Stream.of(1,2,3,4,4,2,3).distinct().forEach(System.out::println);

        Stream.iterate(1, x -> x+1).limit(10).skip(5).forEach(x -> System.out.print(x + " "));
        System.out.println();
        Stream.iterate(1, x -> x+1).limit(10).map(x -> "Ceco" + x*2).forEach(x -> System.out.print(x + " "));

        System.out.println();
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("Bonobo");
        List<String> two = Arrays.asList("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);
        Stream<List<String>> animals2 = Stream.of(zero, one, two);
        Stream<List<String>> animalsSorted = Stream.of(zero, one, two);
        animals.forEach(x -> x.stream().forEach(System.out::println));
        animals2.flatMap(x -> x.stream()).forEach(System.out::println);
        animalsSorted.flatMap(x->x.stream()).sorted().forEach(x -> System.out.print(x + " "));

        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------------------------");


        Stream.of(4, 2, 3)
                .peek(System.out::println)
//                .flatMap(x->x.stream())
//                .peek(System.out::println)
                .sorted()
//                .peek(System.out::println)
                .forEach(x -> System.out.print(x + " "));

        Stream.iterate(1, x -> x+1).limit(2).sorted().forEach(System.out::println);



        Stream<String> myStream = Stream.of("1","2","3");
        myStream.collect(Collectors.joining(", "));

        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Double result = ohMy.collect(Collectors.averagingInt(String::length));
        System.out.println(result); // 5.333333333333333


        Stream.of("cecot", "e", "gotin")
                .collect(Collectors
                        .toMap(String::length , Function.identity(), (s1,s2) -> s1 + " , " + s2, HashMap::new))
                .forEach((k,v) -> System.out.println(k + "=" + v));

        Stream<String> groupingBy = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map = groupingBy.collect(
                Collectors.groupingBy(String::length));
        System.out.println(map); // {5=[lions, bears], 6=[tigers]}

        // partitioning - special case of grouping with only 2 options - true and false option
        // depending on passed Predicate
        // you can also do mapping but it gets very complicated




    }
}

