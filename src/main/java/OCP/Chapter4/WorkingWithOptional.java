package OCP.Chapter4;

import javax.swing.text.html.Option;
import java.util.Optional;

public class WorkingWithOptional {
    public static void main(String[] args) {

        // static methods
        Optional<String> opt = Optional.empty();
        Optional<String> opt2 = Optional.of("Ceco");

        Optional opt3 = Optional.ofNullable("Ceco");

        //instance methods
        opt.get(); //returns value, throws exception if empty
        opt.ifPresent(System.out::println);
        opt.isPresent(); // true or false
        opt.orElse("What?");
        opt.orElseGet(()-> "This is it");
        opt.orElseThrow(() -> new NullPointerException("whaat"));

    }
}
