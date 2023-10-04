package Functional;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProbs {

    // doubling

    public List<Integer> doubling(List<Integer> nums) {
        return nums.stream() // convert list into stream of integers
                .map(num -> num * 2) // map operation to double each element
                .collect(Collectors.toList()); // collect modified elements into new list
    }










}
