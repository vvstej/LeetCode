package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo3 {
    
    public static void main(final String[] args) {
        final List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(10);
        numbers.add(18);
        numbers.add(21);
        numbers.add(24);
        
        mutipleof2And3(numbers);
    }
    
    private static void mutipleof2And3(final List<Integer> numbers){
        final Predicate<Integer> multipleOf2 = num -> num%2 == 0;
        final Predicate<Integer> multipleOf3 = num -> num%3 == 0;
        System.out.println("Multiples of 2 and 3 in numbers list are : ");
        for(final Integer num : numbers){
            if((multipleOf2.and(multipleOf3)).test(num))
                System.out.println(num);
        }
    }
 
}
