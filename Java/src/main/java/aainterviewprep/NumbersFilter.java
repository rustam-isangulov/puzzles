package aainterviewprep;

import java.util.List;
import java.util.function.Predicate;

public class NumbersFilter {
    public long countByRule( List<Integer> numbers, Predicate<Integer> rule ) {

        if (numbers == null || rule == null) {
            throw new IllegalArgumentException("One or both arguments are null!");
        }

        return numbers.stream().filter(rule).count();
    }
}
