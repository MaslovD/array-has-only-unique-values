package dmitr.io;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {


    public static void main(String[] args) {
        long start;

        int[] intArray = new Random().ints(50000).toArray();

        System.out.println(intArray.length);


        // Set based (O n)
        start = System.currentTimeMillis();

        Set integerSet = IntStream.of(intArray)
                .boxed()
                .collect(Collectors.toSet());

        if (intArray.length != integerSet.size()) System.out.println("Array has unqniue values");

        System.out.println(System.currentTimeMillis() - start);

        // HashMap Based (O 1)
        start = System.currentTimeMillis();

        Map<Integer, Integer> integerHashMap = new HashMap<>();

        for (int intVal : intArray)

            if (integerHashMap.get(intVal) == null) {
                integerHashMap.put(intVal, 0);
            } else {
                //System.out.println("Array has unqniue values:".concat(intVal));
                break;
            }
        System.out.println(System.currentTimeMillis() - start);
    }
}
