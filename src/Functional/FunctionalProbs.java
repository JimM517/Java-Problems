package Functional;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProbs {

    // doubling
    public List<Integer> doubling(List<Integer> nums) {
        // solution one
        // nums.replaceAll(num -> num * 2);
        // return nums;

        // solution two
        return nums.stream() // convert list into stream of integers
                .map(num -> num * 2) // map operation to double each element
                .collect(Collectors.toList()); // collect modified elements into new list
    }


    // square
    public List<Integer> square(List<Integer> nums) {
        return nums.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());
    }








}
