package OCP.Chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCollections {

    public static void main(String[] args) {
        String[] arrayStrings = {"ceco", "The", "best"};
        List<String> arrayAsList = Arrays.asList(arrayStrings);
        List<String> myArrayList = new ArrayList<>();

        arrayStrings[0] = "bobi";
        arrayAsList.set(2,"worst");

        System.out.println(Arrays.toString(arrayStrings));
        System.out.println(arrayAsList);
        System.out.println(arrayAsList.getClass().getName());
        System.out.println(myArrayList.getClass().getName());

    }

}
